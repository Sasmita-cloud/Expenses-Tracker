**Project Overview**
Built a simple expense tracker application to manage your finances. 
The application should allow users to add, delete, and view their expenses. The application should also provide a summary of the expenses.

**Requirements**
Application should run from the command line and should have the following features:

1.Users can add an expense with a description and amount.
2.Users can update an expense.
3.Users can delete an expense.
4.Users can view all expenses.
5.Users can view a summary of all expenses.
6.Users can view a summary of expenses for a specific month (of current year).

**We built a Spring Boot application that:**

Uses Spring Web and Spring Data JPA.
Persists data in an H2 in-memory database.
Exposes REST endpoints for managing expenses.
Supports:
1.Add expense
2.Update expense
3.Delete expense
4.View all expenses
5.Summaries (overall and monthly)


⚙️ **Technologies**
Java 17+
Spring Boot 3.x
Spring Web
Spring Data JPA
H2 Database
Lombok (for clean code)


📁 Project Structure ::

expense-tracker/
│
├── src/main/java/com/example/expensetracker/
│   ├── ExpenseTrackerApplication.java
│   ├── controller/
│   │   └── ExpenseController.java
│   ├── model/
│   │   └── Expense.java
│   ├── repository/
│   │   └── ExpenseRepository.java
│   ├── service/
│   │   └── ExpenseService.java
│   └── utils/
│       └── CsvExporter.java
│
└── src/main/resources/
    ├── application.properties
    └── data.sql  (optional demo data)
