package com.example.expenseTracker.Repository;
import com.example.expenseTracker.Model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.Month;
import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Long>{
    @Query("Select e from Expense e where Month(e.createdOn)=?1 and YEAR(e.createdOn) = YEAR(CURRENT_DATE)")
    List<Expense> findByMonth(int month);
}