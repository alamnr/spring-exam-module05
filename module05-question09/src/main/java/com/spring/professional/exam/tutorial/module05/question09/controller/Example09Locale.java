package com.spring.professional.exam.tutorial.module05.question09.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Example09Locale {

	// curl -H "Accept-Language: en"  localhost:8080/actionI
	// curl -H  "Accept-Language: es" localhost:8080/actionI
	// curl -H  "Accept-Language: pl" localhost:8080/actionI
	
	@RequestMapping("/actionI")
	@ResponseBody
	public String actionI(Locale locale ) {
		return String.format("Locale = [%s]\n", locale.getDisplayName());
	}
 
}
