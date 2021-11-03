package com.spring.professional.exam.tutorial.module05.question10.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Example02PathVariable {

	// curl  "http://localhost:8080/example02A/firstName/John/lastName/Doe"
	@GetMapping("/example02A/firstName/{firstName}/lastName/{lastName}")
	@ResponseBody
	public String example02A(@PathVariable("firstName")String firstName,@PathVariable("lastName") String lastName)
	{
		return String.format("Received request param firstName = [%s] and lastName = [%s] \n", firstName, lastName);
	}
	
	// curl  "http://localhost:8080/example02B/firstName/John/lastName/Doe"
	// curl "http://localhost:8080/example02B/firstName/John"
	
	@GetMapping({"/example02B/firstName/{firstName}/lastName/{lastName}",
			"/example02B/firstName/{firstName}"}
			)
	@ResponseBody
	public String example02B(@PathVariable("firstName") String firstName,
			@PathVariable(value = "lastName" , required = false)String lastName)
	{
		return String.format("Received request param firstName = [%s] and lastName = [%s] \n", firstName,lastName);
	}
	
	// curl "http://localhost:8080/example02C/firstName/John/lastName/Doe"
	// curl "http://localhost:8080/example02C/firstName/John"
	@GetMapping({"/example02C/firstName/{firstName}/lastName/{lastName}","/example02C/firstName/{firstName}"})
	@ResponseBody
	public String example02C(@PathVariable("firstName")String firstName,@PathVariable(value = "lastName" , required = false) Optional<String> lastName)
	{
		return String.format("Received firstName = [%s] and lastName = [%s] \n", firstName,lastName.orElse("N/A"));
	}
}
