package com.spring.professional.exam.tutorial.module05.question02.my.servlet.framework.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spring.professional.exam.tutorial.module05.question02.my.servlet.framework.controller.IController;
import com.spring.professional.exam.tutorial.module05.question02.my.servlet.framework.ds.ModelAndView;
import com.spring.professional.exam.tutorial.module05.question02.my.servlet.framework.model.Model;
import com.spring.professional.exam.tutorial.module05.question02.my.servlet.framework.utils.ApplicationControllersFinder;
import com.spring.professional.exam.tutorial.module05.question02.my.servlet.framework.view.View;

@WebServlet(name = "framework-servlet",urlPatterns = "/*")
public class FrameworkHttpServlet extends HttpServlet {
	
	private Map<String , IController> uriToControllerMap;

	@Override
	public void init() {		
		
		uriToControllerMap = new ApplicationControllersFinder().findControllers();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String requestUri = req.getRequestURI();
		IController controller = uriToControllerMap.get(requestUri);
		
		if(controller!=null) {
			
			ModelAndView modelAndView = controller.handleRequest(req);
			Model model = modelAndView.getModel();
			View view = modelAndView.getView();
			
			String renderView = view.render(model);
			
			resp.setContentType("text/html");
			resp.getWriter().print(renderView);
			
		} else {
			throw new ServletException(String.format("Unable to find controller for request uri [%s] ", requestUri));
		}
		
	}
	
	

}
