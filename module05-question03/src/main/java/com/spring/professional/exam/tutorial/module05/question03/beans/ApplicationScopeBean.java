package com.spring.professional.exam.tutorial.module05.question03.beans;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.SessionScope;

import lombok.Data;

@ApplicationScope
@Component
@Data
public class ApplicationScopeBean {
	private Integer value;
}
