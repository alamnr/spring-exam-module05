package com.spring.professional.exam.tutorial.module05.question11.ds;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {

	@NotBlank(message = "First name can not be empty.")
	@Pattern(regexp="[A-Za-z-']*" , message = "First name contains illegal character")
	private String firstName;
	
	@NotBlank(message = "Last name can not be empty")
	@Pattern(regexp = "[A-Za-z-']*", message = "Last name contains illegal character")
	private String lastName;
}
