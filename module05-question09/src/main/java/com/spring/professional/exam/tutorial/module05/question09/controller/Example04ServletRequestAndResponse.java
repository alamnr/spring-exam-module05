package com.spring.professional.exam.tutorial.module05.question09.controller;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Example04ServletRequestAndResponse {

	// curl "localhost:8080/actionD"
	@GetMapping("/actionD")
	@ResponseBody
	public void actionD(ServletRequest request,ServletResponse response) throws IOException {
		response.getOutputStream().println(
				String.format("Retrieved request on server = [%s : %d]\n", request.getServerName(),request.getServerPort())
				);
	}
}
