package com.spring.professional.exam.tutorial.module05.question11.controller;

import com.spring.professional.exam.tutorial.module05.question11.ds.Person;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

import static java.util.Arrays.asList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Controller
public class Example08ModelAndView {

    // Visit http://localhost:8080/example08A
    @GetMapping("/example08A")
    public ModelAndView example08A() {
        return new ModelAndView(
                "person-display",
                "person",
                new Person("John", "Doe")
        );
    }

    // Visit http://localhost:8080/example08B
    @GetMapping("/example08B")
    public ModelAndView example08B() {
    	Map map = new HashMap<String,List<String>>();
		map.put("names", Arrays.asList("John","Marry","Jane","Joe"));
		map.put("cities", Arrays.asList("New York","Tokyo","Sydney","Dhaka"));
        return new ModelAndView(
                "names-and-cities",
                map,
                HttpStatus.OK
        );
    }
}
