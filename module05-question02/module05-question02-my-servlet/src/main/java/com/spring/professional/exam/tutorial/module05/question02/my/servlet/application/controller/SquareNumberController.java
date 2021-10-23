package com.spring.professional.exam.tutorial.module05.question02.my.servlet.application.controller;

import javax.servlet.http.HttpServletRequest;

import com.spring.professional.exam.tutorial.module05.question02.my.servlet.application.view.SquareNumberView;
import com.spring.professional.exam.tutorial.module05.question02.my.servlet.framework.controller.ControllerMapping;
import com.spring.professional.exam.tutorial.module05.question02.my.servlet.framework.controller.IController;
import com.spring.professional.exam.tutorial.module05.question02.my.servlet.framework.ds.ModelAndView;
import com.spring.professional.exam.tutorial.module05.question02.my.servlet.framework.model.Model;
import com.spring.professional.exam.tutorial.module05.question02.my.servlet.framework.model.SimpleModel;

import static java.lang.String.valueOf;

@ControllerMapping("/square-number")
public class SquareNumberController implements IController {

	@Override
	public ModelAndView handleRequest(HttpServletRequest req) {
		Model model = new SimpleModel();
		
		int number = Integer.parseInt(req.getParameter("number"));
		
		model.set("number", valueOf(number));
		model.set("numberSquare", valueOf(number*number));
		
		return new ModelAndView(model, new SquareNumberView());
	}

}
