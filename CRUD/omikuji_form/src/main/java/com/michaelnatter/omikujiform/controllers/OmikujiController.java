package com.michaelnatter.omikujiform.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class OmikujiController {
	
	@RequestMapping("/form")
	public String displayForm() {
		
		return "form.jsp";
	}
	
	@RequestMapping(value="/form/process", method=RequestMethod.POST)
	public String processForm(HttpSession session, @RequestParam(value="number") String number,
			@RequestParam(value="city") String city, @RequestParam(value="person") String person,
			@RequestParam(value="proEndeavorOrHobby") String proEndeavorOrHobby, 
			@RequestParam(value="livingThing") String livingThing, 
			@RequestParam(value="somethingNice") String somethingNice) {
		
		session.setAttribute("number", number);
		session.setAttribute("city", city);
		session.setAttribute("person", person);
		session.setAttribute("proEndeavorOrHobby", proEndeavorOrHobby);
		session.setAttribute("livingThing", livingThing);
		session.setAttribute("somethingNice", somethingNice);
	
		return "redirect:/view";
	}
	
	@RequestMapping(value="/view")
	public String view(HttpSession session, Model model) {
		
		String number = (String) session.getAttribute("number");
		String city = (String) session.getAttribute("city");
		String person = (String) session.getAttribute("person");
		String proEndeavorOrHobby = (String) session.getAttribute("proEndeavorOrHobby");
		String livingThing = (String) session.getAttribute("livingThing");
		String somethingNice = (String) session.getAttribute("somethingNice");
		
		model.addAttribute("number", number);
		model.addAttribute("city", city);
		model.addAttribute("person", person);
		model.addAttribute("proEndeavorOrHobby", proEndeavorOrHobby);
		model.addAttribute("livingThing", livingThing);
		model.addAttribute("somethingNice", somethingNice);
		
		return "view.jsp";
	}
}
