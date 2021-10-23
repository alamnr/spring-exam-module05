package com.spring.professional.exam.tutorial.module05.question02.my.servlet.application.view;

import com.spring.professional.exam.tutorial.module05.question02.my.servlet.framework.model.Model;
import com.spring.professional.exam.tutorial.module05.question02.my.servlet.framework.view.View;

public class SquareNumberView implements View {

	@Override
	public String render(Model model) {		
		return String.format("Square number of [%s] is [%s]", model.get("number"),model.get("numberSquare"));
	}

}
