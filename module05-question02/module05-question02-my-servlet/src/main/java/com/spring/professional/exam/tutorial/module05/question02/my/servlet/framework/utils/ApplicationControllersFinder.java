package com.spring.professional.exam.tutorial.module05.question02.my.servlet.framework.utils;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.reflections.Reflections;

import com.spring.professional.exam.tutorial.module05.question02.my.servlet.framework.controller.ControllerMapping;
import com.spring.professional.exam.tutorial.module05.question02.my.servlet.framework.controller.IController;

public class ApplicationControllersFinder {
	
	public Map<String , IController> findControllers(){
		return new Reflections()
				.getTypesAnnotatedWith(ControllerMapping.class)
				.stream()
				.map(this::getAsControllerClass)
				.map(this::getControllerInstance)
				.collect(Collectors.toMap(this::getUri, Function.identity()));
	}
	
	
	private Class<IController> getAsControllerClass(Class<?> controller){
		return (Class<IController>) controller;
	}
	
	private IController getControllerInstance(Class<IController> controller) {
		try {
			return controller.getConstructor().newInstance();
		} catch (Exception e) {
			throw new RuntimeException(String.format("Error occured while creating instance of controller %s : %s", controller.getSimpleName(), e.getMessage()), e);
		}
	}
	
	private String getUri(IController controller) {
		return controller.getClass().getAnnotation(ControllerMapping.class).value();
	}

}
