package com.spring.professional.exam.tutorial.module05.question02.my.servlet.application.view;

import com.spring.professional.exam.tutorial.module05.question02.my.servlet.framework.ds.ModelAndView;
import com.spring.professional.exam.tutorial.module05.question02.my.servlet.framework.model.Model;
import com.spring.professional.exam.tutorial.module05.question02.my.servlet.framework.view.View;

public class AddNumbersView implements View {

	@Override
	public String render(Model model) {
		return String.format("Result of adding numberA = [%s] and numberB= [%s] is [%s]",
				model.get("numberA"),model.get("numberB"),model.get("result") );
	}

}
