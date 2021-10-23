package com.spring.professional.exam.tutorial.module05.question02.my.servlet.application.controller;

import javax.servlet.http.HttpServletRequest;

import com.spring.professional.exam.tutorial.module05.question02.my.servlet.application.view.IndexView;
import com.spring.professional.exam.tutorial.module05.question02.my.servlet.framework.controller.ControllerMapping;
import com.spring.professional.exam.tutorial.module05.question02.my.servlet.framework.controller.IController;
import com.spring.professional.exam.tutorial.module05.question02.my.servlet.framework.ds.ModelAndView;
import com.spring.professional.exam.tutorial.module05.question02.my.servlet.framework.model.SimpleModel;

@ControllerMapping("/")
public class IndexController implements IController {

	@Override
	public ModelAndView handleRequest(HttpServletRequest req) {
		
		return new ModelAndView(new SimpleModel(),new IndexView());
	}

}
