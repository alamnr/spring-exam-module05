package com.spring.professional.exam.tutorial.module05.question09.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Example07Principal {

	// Visit "http://localhost:8080/actionG" in your browser
	// use john/john or mary/mary as  user name and pass word
	
	@GetMapping("/actionG")
	@ResponseBody
	public String actionG(Principal principal) {
		return String.format("Authenticated with principal = [%s] \n", principal.getName());
	}
}
