package com.mehedi.exapense.manager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    List<Expense> findAllByOrderByDateAsc();

    List<Expense> findAllByOrderByDateDesc();

    List<Expense> findAllByOrderByAmountAsc();

    List<Expense> findAllByOrderByAmountDesc();

    List<Expense> findAllByOrderByCategoryAsc();

    List<Expense> findAllByOrderByCategoryDesc();
}