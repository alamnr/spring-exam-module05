package com.spring.professional.exam.tutorial.module05.question09.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class Example14RedirectAttribute {

	// Visit "http://localhost:8080/actionN1" in your browser
	@GetMapping("/actionN1")
	public String actionN1(RedirectAttributes redirectAttributes) {
		redirectAttributes.addAttribute("firstName", "John");
		redirectAttributes.addFlashAttribute("lastName", "Jane");
		redirectAttributes.addFlashAttribute("city", "Denver");
		
		return "redirect:/actionN2";
	}
	
	// Visit "http://localhost:8080/actionN2" in your browser
	
	@GetMapping("/actionN2")
	public String actionN2(@RequestParam("firstName") String firstName,@ModelAttribute("lastName") String lastName
			,@ModelAttribute("city") String city,Model model) {
		// lastName and city are already in model, they do not have to be added
		model.addAttribute("firstName", firstName);
		return "list-attributes";
	}
	
}
