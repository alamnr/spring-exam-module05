package com.spring.professional.exam.tutorial.module05.question05.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import com.spring.professional.exam.tutorial.module05.question05.dao.ArticlesDao;
import com.spring.professional.exam.tutorial.module05.question05.ds.Article;

@Controller
public class IndexController {

	@Autowired
	private ArticlesDao articlesDao;
	
	
	
	@GetMapping({"/","/index","/home"})
	public String index(Model model) {
				
		model.addAttribute("articles", articlesDao.findAll());
		return "index";
	}  
	
}
