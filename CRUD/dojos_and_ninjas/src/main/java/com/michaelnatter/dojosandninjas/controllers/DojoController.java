package com.michaelnatter.dojosandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.michaelnatter.dojosandninjas.models.Dojo;
import com.michaelnatter.dojosandninjas.models.Ninja;
import com.michaelnatter.dojosandninjas.services.DojoService;
import com.michaelnatter.dojosandninjas.services.NinjaService;

@Controller
public class DojoController {

	@Autowired
	DojoService dojoService;
	@Autowired
	NinjaService ninjaService;
	
	@GetMapping ("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "new_dojo.jsp";
	}
	
	@PostMapping ("/dojos")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		
		if (result.hasErrors()) {
			return "new_dojo.jsp";
		}
		else {
			dojoService.createDojo(dojo);
			return "redirect:/dojos/new";
		}
	}
	
	@GetMapping ("/dojos/{id}")
	public String showDojo(@PathVariable("id") Long id, Model model) {
		Dojo dojo=dojoService.oneDojo(id);
		model.addAttribute("dojo", dojo);
		
		List<Ninja> ninjas=dojo.getNinjas();
		model.addAttribute("ninjas", ninjas);
		
		
		return "show_dojo.jsp";
	}
	
	
	
}
