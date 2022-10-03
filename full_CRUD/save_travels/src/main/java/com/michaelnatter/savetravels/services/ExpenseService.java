package com.michaelnatter.savetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.michaelnatter.savetravels.models.Expense;
import com.michaelnatter.savetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
    // adding the expense repository as a dependency
    private final ExpenseRepository expenseRepository;
    
    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public List<Expense> allExpenses() {
        return expenseRepository.findAll();
    }
    
    public Expense createExpense(Expense expense) {
        return expenseRepository.save(expense);
    }
    
    public Expense oneExpense(Long id) {
		Optional<Expense> optionalExpense = expenseRepository.findById(id);
		if(optionalExpense.isPresent()) {
			return optionalExpense.get();
		}else {
			return null;
		}
    }
    
    public void removeExpense(Long id) {
    	expenseRepository.deleteById(id);
    }

}
