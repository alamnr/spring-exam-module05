package com.spring.professional.exam.tutorial.module05.question09.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

// Map<String,String>, Model, ModelMap example 
@Controller
public class Example13Model {

	// Visit "http://localhost:8080/actionM1" in your browser
	@GetMapping("/actionM1")
	public String actionM1(Map<String,String> model) {
		model.put("firstName", "John");
		model.put("lastName", "Doe");
		model.put("email", "john.doe@corp.com");
		model.put("city", "Los Angeles");
		
		return "address";
	}
	
	// Visit "http:localhost:8080/actionM2" in your browser
	
	@GetMapping("/actionM2")
	public String actionM2(Model model) {
		model.addAttribute("firstName", "john");
		model.addAttribute("lastName","Doe");
		model.addAttribute("email","john.doe@corp.com");
		model.addAttribute("city", "New York");
		return "address";
		}
	
	// Visit "http://localhost:8080/actionM3" in your browser
	
	@GetMapping("/actionM3")
	public String actionM3(ModelMap modelMap) {
		
		modelMap.addAttribute("firstName", "john");
		modelMap.addAttribute("lastName","Doe");
		modelMap.addAttribute("email","john.doe@corp.com");
		modelMap.addAttribute("city", "New York");
		return "address";
	}
}
