package com.spring.professional.exam.tutorial.module05.question06.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

	// curl -X GET localhost:8080/actionA
	@GetMapping("/actionA")
	@ResponseBody
	public String actionA() {
		return "Handled with @GetMapping (\"/actionA\")\n";
	}
	
	// curl -X GET localhost:8080/actionB
	@RequestMapping(method = RequestMethod.GET, path="/actionB")
	@ResponseBody
	public String actionB() {
		return "Handaled with @RequestMapping(method = RequestMethod.GET, path=\"/actionB\")\n";
	}
	
	// curl -X GET localhost:8080/actionC
	// curl -X POST localhost:8080/actionC
	// curl -X PATCH localhost:8080/actionC
	// curl -X DELETE localhost:8080/actionC
	// curl -X PUT localhost:8080/actionC
	// curl -I  localhost:8080/actionC
	@RequestMapping(path = "/actionC")
	@ResponseBody
	public String actionC() {
		return "Handaled with @RequestMapping(path = \"/actionC\")\n";
	}
	
	// curl -X GET localhost:8080/actionD
	// curl -X POST localhost:8080/actionD
	@RequestMapping(path = "/actionD", method = {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public String actionD() {
		return "Handaled with @RequestMapping(path = \"/actionD\", method = {RequestMethod.GET,RequestMethod.POST})\n ";
	}
}
