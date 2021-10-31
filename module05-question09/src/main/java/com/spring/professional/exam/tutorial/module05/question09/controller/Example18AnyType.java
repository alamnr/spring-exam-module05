package com.spring.professional.exam.tutorial.module05.question09.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.professional.exam.tutorial.module05.question09.ds.Person;

@Controller
public class Example18AnyType {

	// curl "http://localhost:8080/actionS?firstName=John&lastName=Doe"
	@GetMapping("/actionS")
	@ResponseBody
	public String actionS(String firstName,String lastName) {
		return String.format("firstName = [%s] , lastName = [%s] \n", firstName,lastName);
	}
	
	// Visit "http://localhost:8080/actionS/simpleForm" in your browser
	@GetMapping("/actionS/simpleForm")
	public String actionSSimpleForm(Person person) {
		//person.setFirstName("Jane");
		//person.setLastName("Doe");
		return "person-form-simple";
	}
	
	@PostMapping("/actionS/simpleForm")
	//public String actionSSimpleFormSubmit(@Valid Person person, BindingResult bindingResult)
	public String actionSSimpleFormSubmit( Person person)
	{
		
		/*
		if(bindingResult.hasErrors()) {
			return "person-form-simple";
		} else		return "person-display-simple";  */
		
		return "person-display-simple";
	}
}
