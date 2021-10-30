package com.spring.professional.exam.tutorial.module05.question09.controller;

import java.time.ZoneId;
import java.util.TimeZone;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//TimeZone and ZoneId example

@Controller
public class Example10TimeZone {

	// curl localhost:8080/actionJ
	
	@RequestMapping("/actionJ")
	@ResponseBody
	public String actionJ(TimeZone timeZone, ZoneId zoneId) {
		return String.format("Timezone = [%s], zone id = [%s] \n", timeZone.getDisplayName(),zoneId.getId());
	}
}
