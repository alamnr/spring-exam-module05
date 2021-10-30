package com.spring.professional.exam.tutorial.module05.question09.controller;

import javax.servlet.ServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Example03ServletRequest {

	// curl "localhost:8080/actionC"
	@GetMapping("/actionC")
	@ResponseBody
	public String actionC(ServletRequest servletRequest) {
		return String.format("Retrieved request on server = [%s:%d]\n", 
				servletRequest.getRemoteHost(),servletRequest.getLocalPort());
	}
}
