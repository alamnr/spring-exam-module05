package com.spring.professional.exam.tutorial.module05.question02.my.servlet.framework.controller;

import javax.servlet.http.HttpServletRequest;

import com.spring.professional.exam.tutorial.module05.question02.my.servlet.framework.ds.ModelAndView;

public interface IController {
	
	ModelAndView handleRequest(HttpServletRequest req);

}
