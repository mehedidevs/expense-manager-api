package com.mehedi.exapense.manager;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;


    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public Expense getExpenseById(Long id) {
        return expenseRepository.findById(id).orElse(null);
    }

    public Expense createExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    public List<Expense> createExpense(List<Expense> expenses) {
        return expenseRepository.saveAll(expenses);
    }


    public Expense updateExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }

    public List<Expense> getExpensesSortedByDateAsc() {
        return expenseRepository.findAllByOrderByDateAsc();
    }

    public List<Expense> getExpensesSortedByDateDesc() {
        return expenseRepository.findAllByOrderByDateDesc();
    }

    public List<Expense> getExpensesSortedByAmountAsc() {
        return expenseRepository.findAllByOrderByAmountAsc();
    }

    public List<Expense> getExpensesSortedByAmountDesc() {
        return expenseRepository.findAllByOrderByAmountDesc();
    }

    public List<Expense> getExpensesSortedByCategoryAsc() {
        return expenseRepository.findAllByOrderByCategoryAsc();
    }

    public List<Expense> getExpensesSortedByCategoryDesc() {
        return expenseRepository.findAllByOrderByCategoryDesc();
    }


    public Map<String, Double> getTopExpensesByCategory() {
        List<Expense> expenses = expenseRepository.findAll();

        return expenses.stream()
                .collect(Collectors.groupingBy(Expense::getCategory,
                        Collectors.summingDouble(Expense::getAmount)));
    }

    /*
      public List<Expense> getTopExpensesByCategory() {
        List<Expense> expenses = expenseRepository.findAll();

        // Group expenses by category and sum up the amounts for each category
        Map<String, Double> categoryTotalExpenses = expenses.stream()
                .collect(Collectors.groupingBy(Expense::getCategory,
                        Collectors.summingDouble(Expense::getAmount)));

        // Sort the categories based on total expenses in descending order
        List<String> sortedCategories = categoryTotalExpenses.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        // Create a list of expenses sorted by category-wise total expenses
        return expenses.stream()
                .sorted(Comparator.comparingDouble(expense -> sortedCategories.indexOf(expense.getCategory())))
                .collect(Collectors.toList());
    }
     */
}