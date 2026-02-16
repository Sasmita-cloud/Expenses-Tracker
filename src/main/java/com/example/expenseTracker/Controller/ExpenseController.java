package com.example.expenseTracker.Controller;
import com.example.expenseTracker.Model.Expense;
import com.example.expenseTracker.Service.ExpenseService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/expenses")
public class ExpenseController{
    private final ExpenseService service;
    public ExpenseController(ExpenseService service){
        this.service=service;
    }
    @PostMapping
    public Expense addExpense(@RequestBody Expense expense){
        return service.addExpense(expense);
    }
    @GetMapping
    public List<Expense> getAllExpenses(){
        return service.getAllExpenses();
    }
    @DeleteMapping(path="/{ID}")
    public void deleteExpense(@PathVariable("ID") Long ID){
        service.deleteExpense(ID);
    }
    @PutMapping(path="/{ID}")
    public Expense updateExpense(@PathVariable Long ID,@RequestBody Expense expense){
        return service.updateExpense(ID,expense);
    }
    @GetMapping("/summary/{month}")
    public Map<String, Object> getMonthlySummary(@PathVariable int month){
        return Map.of("month",month,
                "total",service.getMonthlyTotal(month),
                "expense",service.getMonthlyExpenses(month)
        );
    }
    @GetMapping("/summary")
    public Map<String, Double> getSummary(){
        return Map.of("totalExpense",service.getTotalExpense());
    }
}