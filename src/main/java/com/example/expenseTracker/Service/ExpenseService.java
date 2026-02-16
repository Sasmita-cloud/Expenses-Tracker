package com.example.expenseTracker.Service;
import com.example.expenseTracker.Model.Expense;
import com.example.expenseTracker.Repository.ExpenseRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService{
    private final ExpenseRepository expRepo;

    public ExpenseService (ExpenseRepository expRepo){
        this.expRepo=expRepo;
    }
    public Expense addExpense(Expense expense){
        if (expense.getCreatedOn() == null) {
            expense.setCreatedOn(LocalDate.now());
        }
        return  expRepo.save(expense);
    }
    public List<Expense> getAllExpenses(){
        return expRepo.findAll();
    }
    public void deleteExpense(Long ID){
        if(!expRepo.existsById(ID)){
            throw new RuntimeException("Expense not found with id " + ID);
        }
        expRepo.deleteById(ID);
    }
    public double getTotalExpense() {
        return expRepo.findAll().stream().mapToDouble(Expense::getAmount).sum();
    }
        //here we use a stream function to convert the list<expense> to java stream and values extarcted are converted to double and added up using sum.
    public double getMonthlyTotal(int month){
        return expRepo.findByMonth(month).stream().mapToDouble(Expense::getAmount).sum();
        }
    public List<Expense> getMonthlyExpenses(int month){
        return expRepo.findByMonth(month);
        }
    public Expense updateExpense(Long ID, Expense updated){
        Optional<Expense> expOpt = expRepo.findById(ID);
        //optional is used to avoid null pointer exception in case of data does not exist
        if(expOpt.isPresent()){
            Expense expense = expOpt.get();
            expense.setDescription(updated.getDescription());
            expense.setAmount(updated.getAmount());
            expense.setUpdatedOn(updated.getUpdatedOn());
            expense.setCategory(updated.getCategory());
            return expRepo.save(expense);
            }
        throw new RuntimeException("Expense not found with id "+ID);
        }

    }
