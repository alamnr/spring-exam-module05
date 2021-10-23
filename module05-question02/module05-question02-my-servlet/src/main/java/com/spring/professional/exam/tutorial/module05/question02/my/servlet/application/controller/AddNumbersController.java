package com.spring.professional.exam.tutorial.module05.question02.my.servlet.application.controller;

import javax.servlet.http.HttpServletRequest;

import com.spring.professional.exam.tutorial.module05.question02.my.servlet.application.view.AddNumbersView;
import com.spring.professional.exam.tutorial.module05.question02.my.servlet.framework.controller.ControllerMapping;
import com.spring.professional.exam.tutorial.module05.question02.my.servlet.framework.controller.IController;
import com.spring.professional.exam.tutorial.module05.question02.my.servlet.framework.ds.ModelAndView;
import com.spring.professional.exam.tutorial.module05.question02.my.servlet.framework.model.Model;
import com.spring.professional.exam.tutorial.module05.question02.my.servlet.framework.model.SimpleModel;

import static java.lang.String.valueOf;

@ControllerMapping("/add-numbers")
public class AddNumbersController implements IController {

	@Override
	public ModelAndView handleRequest(HttpServletRequest req) {
		Model model = new SimpleModel();
		
		int numberA = Integer.parseInt(req.getParameter("numberA"));
		int numberB = Integer.parseInt(req.getParameter("numberB"));
		
		model.set("numberA", valueOf(numberA));
		model.set("numberB", valueOf(numberB));
		model.set("result", valueOf(numberA+numberB));
		return new ModelAndView(model, new AddNumbersView());
	}

}
