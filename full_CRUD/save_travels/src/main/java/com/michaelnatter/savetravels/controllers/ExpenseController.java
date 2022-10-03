package com.michaelnatter.savetravels.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.michaelnatter.savetravels.models.Expense;
import com.michaelnatter.savetravels.services.ExpenseService;

@Controller
public class ExpenseController {
	
    @Autowired
    ExpenseService expenseService;

	@GetMapping ("/expenses")
	public String index(Model model, @ModelAttribute("expense") Expense expense) {
		
		List<Expense> expenses = expenseService.allExpenses();
		
    	model.addAttribute("expenses", expenses);
	
		return "index.jsp";
	}
	
	@PostMapping ("/expenses/new")
	public String addExpense(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
    
		if (result.hasErrors()) {
			return "index.jsp";
		}
		else {
			expenseService.createExpense(expense);
		}
		return "redirect:/expenses";
		
	}
	
	@GetMapping ("/expenses/edit/{id}")
	public String displayEdit(@PathVariable("id")Long id, Model model) {
		Expense expense = expenseService.oneExpense(id);
		model.addAttribute("expense", expense);
		return "edit.jsp";
	}
	
	@PutMapping ("/expenses/{id}")
	public String editExpense(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
		if (result.hasErrors()) {
			return "edit.jsp";
		}
		else {
			expenseService.createExpense(expense);
			return "redirect:/expenses";
		}
	}
	
	@DeleteMapping ("/expenses/delete/{id}")
	public String deleteExpense(@PathVariable("id") Long id) {
		expenseService.removeExpense(id);
		return "redirect:/expenses";
	}
    
	@RequestMapping ("/expenses/{id}")
	public String expenseDetails(@PathVariable("id") Long id, Model model) {
		Expense expense = expenseService.oneExpense(id);
		model.addAttribute("expense", expense);
		return "show.jsp";
	}
	
//	@GetMapping ("/expenses")
//	public String index(Model model) {
	
//		
//		List<Expense> expenses = expenseService.allExpenses();
//		
//		model.addAttribute("expenses", expenses);
//		
//		return "index.jsp";
//	}
//	
//	@PostMapping ("/expenses/new")
//	public String addExpense(@RequestParam(value="expenseName") String expenseName,
//							@RequestParam(value="vendor") String vendor,
//							@RequestParam(value="amount") Float amount,
//							@RequestParam(value="description") String description)
//	{
//		Expense newExpense = new Expense(expenseName, vendor, amount, description);
//		expenseService.createExpense(newExpense);
//		
//		return "redirect:/expenses";
//	}
	
}
