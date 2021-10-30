package com.spring.professional.exam.tutorial.module05.question09.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Example05HttpSession {

	// curl -c cookie.txt -b cookie.txt localhost:8080/actionE
	
	@GetMapping("/actionE")
	@ResponseBody
	public String actionE(HttpSession httpSession) {
		Integer counter = (Integer)httpSession.getAttribute("counter");
		if(counter == null) {
			httpSession.setAttribute("counter", 0);
			counter = 0;
		}
		httpSession.setAttribute("counter", ++counter);
		return String.format("Counter = [%d]\n", counter);
	}
}
