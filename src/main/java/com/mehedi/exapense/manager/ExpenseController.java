package com.mehedi.exapense.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping
    public List<Expense> getAllExpenses() {
        return expenseService.getAllExpenses();
    }

    @GetMapping("/{id}")
    public Expense getExpenseById(@PathVariable Long id) {
        return expenseService.getExpenseById(id);
    }

    @PostMapping
    public Expense createExpense(@RequestBody Expense expense) {
        return expenseService.createExpense(expense);
    }

    @PostMapping("add/bulk")
    public List<Expense> createBulkExpense(@RequestBody List<Expense> expenses) {
        return expenseService.createExpense(expenses);
    }

    @PutMapping("/{id}")
    public Expense updateExpense(@PathVariable Long id, @RequestBody Expense expense) {
        expense.setId(id);
        return expenseService.updateExpense(expense);
    }

    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);
    }

    @GetMapping("/sort/date/asc")
    public List<Expense> getExpensesSortedByDateAsc() {
        return expenseService.getExpensesSortedByDateAsc();
    }

    @GetMapping("/sort/date/desc")
    public List<Expense> getExpensesSortedByDateDesc() {
        return expenseService.getExpensesSortedByDateDesc();
    }

    @GetMapping("/sort/amount/asc")
    public List<Expense> getExpensesSortedByAmountAsc() {
        return expenseService.getExpensesSortedByAmountAsc();
    }

    @GetMapping("/sort/amount/desc")
    public List<Expense> getExpensesSortedByAmountDesc() {
        return expenseService.getExpensesSortedByAmountDesc();
    }

    @GetMapping("/sort/category/asc")
    public List<Expense> getExpensesSortedByCategoryAsc() {
        return expenseService.getExpensesSortedByCategoryAsc();
    }

    @GetMapping("/sort/category/desc")
    public List<Expense> getExpensesSortedByCategoryDesc() {
        return expenseService.getExpensesSortedByCategoryDesc();
    }

    @GetMapping("/top-by-category")
    public Map<String, Double> getTopExpensesByCategory() {
        return expenseService.getTopExpensesByCategory();
    }

}
