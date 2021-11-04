package com.spring.professional.exam.tutorial.module05.question11.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Example06Model {

	// visit http://localhost:8080/example06A
	@GetMapping("/example06A")
	public Model example06A() {
		Model model = new BindingAwareModelMap();
		model.addAttribute("names",Arrays.asList("John","Mary","William","Jane"));
		model.addAttribute("cities", Arrays.asList("New York Cities", "Tokyo","Sydney","Dhaka"));
		return model;
	}
	
	// visit http://localhost:8080/example06B
	@GetMapping("/example06B")
	public Map example06B() {
		Map map = new HashMap<String,List<String>>();
		map.put("names", Arrays.asList("John","Marry","Jane","Joe"));
		map.put("cities", Arrays.asList("New York","Tokyo","Sydney","Dhaka"));
		return map;
	}
}
