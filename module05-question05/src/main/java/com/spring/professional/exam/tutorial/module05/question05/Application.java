package com.spring.professional.exam.tutorial.module05.question05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.context.WebApplicationContext;

import com.spring.professional.exam.tutorial.module05.question05.controller.ApiController;

@SpringBootApplication
public class Application {

	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
	}
}
