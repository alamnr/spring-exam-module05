package com.spring.professional.exam.tutorial.module05.question02.my.servlet.framework.ds;

import com.spring.professional.exam.tutorial.module05.question02.my.servlet.framework.model.Model;
import com.spring.professional.exam.tutorial.module05.question02.my.servlet.framework.view.View;

public class ModelAndView {
	
	private Model model;
	private View view;
	
	public ModelAndView(Model model,View view) {
		this.model = model;
		this.view = view;
	}
	
	public Model getModel() {
		return model;
	}
	
	public View getView() {
		return view;
	}

}
