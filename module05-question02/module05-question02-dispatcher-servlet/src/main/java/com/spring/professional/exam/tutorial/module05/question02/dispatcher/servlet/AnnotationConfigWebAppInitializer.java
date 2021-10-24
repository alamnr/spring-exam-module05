package com.spring.professional.exam.tutorial.module05.question02.dispatcher.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class AnnotationConfigWebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
	 AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
	 
	 context.setServletContext(servletContext);
	 context.register(ApplicationConfiguration.class);
	 context.refresh();
	 
	 ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(context));
	 dispatcher.setLoadOnStartup(1);
	 dispatcher.addMapping("/");
		
	}

}
