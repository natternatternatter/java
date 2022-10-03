package com.michaelnatter.dojosandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.michaelnatter.dojosandninjas.models.Dojo;
import com.michaelnatter.dojosandninjas.models.Ninja;
import com.michaelnatter.dojosandninjas.services.DojoService;
import com.michaelnatter.dojosandninjas.services.NinjaService;

@Controller
public class NinjaController {

		@Autowired
		NinjaService ninjaService;
		@Autowired
		private DojoService dojoService;
		
		@GetMapping ("/ninjas/new")
		public String newNinja(Model model, @ModelAttribute("ninja") Ninja ninja) {
			List<Dojo> dojos=dojoService.allDojos();
			model.addAttribute("dojos", dojos);
			return "new_ninja.jsp";
		}
		
		@PostMapping ("/ninjas")
		public String createNinja(Model model, @Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
			if (result.hasErrors()) {
				List<Dojo> dojos=dojoService.allDojos();
				model.addAttribute("dojos", dojos);
				return "new_ninja.jsp";

			}
			else {
				ninjaService.createNinja(ninja);
				return "redirect:/ninjas/new";
			}
		}
		
		
}
