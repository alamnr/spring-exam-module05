package com.spring.professional.exam.tutorial.module05.question11.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.professional.exam.tutorial.module05.question11.ds.Person;

@Controller
public class Example01ResponseBody {

	// curl http://localhost:8080/example01A
	@GetMapping("/example01A")
	@ResponseBody
	public String example01A() {
		return "Response Content from example01A \n";
	}
	
	// curl http://localhost:8080/example01B
	@GetMapping("/example01B")
	@ResponseBody
	public Person example01B() {
		return new Person("John", "Doe");
	}
	
}
