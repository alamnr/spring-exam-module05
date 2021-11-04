package com.spring.professional.exam.tutorial.module05.question11.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.View;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import com.spring.professional.exam.tutorial.module05.question11.ds.Person;

@Controller
public class Example05ViewResponse {

	@Autowired
	private ThymeleafViewResolver thymeleafViewResolver;
	
	// visit http://localhost:8080/example05A
	@GetMapping("/example05A")
	public View example05A() throws Exception {
		return thymeleafViewResolver.resolveViewName("hello", Locale.getDefault());
	}
	
	// visit http://localhost:8080/example05B
	@GetMapping("/example05B")
	public View example05B(@ModelAttribute Person person) throws Exception {
		return thymeleafViewResolver.resolveViewName("person", Locale.getDefault());
	}
	
	@PostMapping("/example05B")
	public View example05BSubmit(@ModelAttribute @Valid Person person , BindingResult bindingResult, Model model) throws Exception {
		model.addAttribute("submit", true);
		return thymeleafViewResolver.resolveViewName("person", Locale.getDefault());
	}
}
