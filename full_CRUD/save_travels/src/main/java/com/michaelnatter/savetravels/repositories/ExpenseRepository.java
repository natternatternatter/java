package com.michaelnatter.savetravels.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.michaelnatter.savetravels.models.Expense;

public interface ExpenseRepository extends CrudRepository<Expense, Long>{

	Optional<Expense> findById(Long id);
	
	List<Expense> findAll();
	
	@SuppressWarnings("unchecked")
	Expense save(Expense expense);
	
	void deleteById(Long id);
	
}
