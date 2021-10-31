package com.spring.professional.exam.tutorial.module05.question09.controller;

import javax.sql.rowset.Joinable;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

//import static com.spring.professional.exam.tutorial.module05.question09.utils.JoinUtils.join;

@Controller
public class Example01WebRequest {

	/*
	 * // curl "localhost:8080/actionA?name=John&country=US"
	 * 
	 * @GetMapping("/actionA")
	 * 
	 * @ResponseBody public String actionA(WebRequest webRequest) { return
	 * String.format("Retrieved request with header = [%s], parameter = [%s]\n",
	 * join(webRequest.getHeaderNames()),join(webRequest.getParameterNames())); }
	 */
}
