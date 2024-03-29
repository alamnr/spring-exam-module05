package com.spring.professional.exam.tutorial.module05.question11.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.professional.exam.tutorial.module05.question11.ds.Person;

@Controller
public class Example04StringResponse {

	// visit http://localhost:8080/example04A
	@GetMapping("/example04A")
	public String example04A() {
		return "hello";
	}
	
	// visit http://localhost:8080/example04B
	@GetMapping("/example04B")
	public String example04B(@ModelAttribute  Person person) {
		return "person";
	}
	
	@PostMapping("/example04B")
	public String example04Submit(@ModelAttribute @Valid Person person, BindingResult bindingResult,Model model)
	{
		model.addAttribute("submit", true);
		return "person";
	}
}
