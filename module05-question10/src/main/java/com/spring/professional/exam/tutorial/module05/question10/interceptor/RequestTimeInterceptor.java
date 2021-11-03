package com.spring.professional.exam.tutorial.module05.question10.interceptor;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.spring.professional.exam.tutorial.module05.question10.ds.MutableCountHolder;

@Component
public class RequestTimeInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		request.setAttribute("processing-time", LocalDateTime.now());
		
		if(request.getSession().getAttribute("mutableCountHolder")==null) {
			request.getSession().setAttribute("mutableCountHolder", new MutableCountHolder());
		}

        return true;

	}

	
}
