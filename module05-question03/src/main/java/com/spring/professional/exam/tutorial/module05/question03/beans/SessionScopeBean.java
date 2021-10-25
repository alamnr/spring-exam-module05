package com.spring.professional.exam.tutorial.module05.question03.beans;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import lombok.Data;

@SessionScope
@Component
@Data
public class SessionScopeBean {
	private Integer value;
}
