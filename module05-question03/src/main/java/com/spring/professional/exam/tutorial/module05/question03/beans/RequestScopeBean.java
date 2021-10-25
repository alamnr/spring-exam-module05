package com.spring.professional.exam.tutorial.module05.question03.beans;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import lombok.Data;

@RequestScope
@Component
@Data
public class RequestScopeBean {
	private Integer value;
}
