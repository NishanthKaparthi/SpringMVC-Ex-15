package com.montrealcollege.exercise15.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
public class Employee {
	@NotNull
	@Min(value = 1, message = "atleast min value should be greater than 0")
	private Integer id;
	private String firstName;
	@NotNull
	@Size(min = 2, message = "value should be more than 2")
	private String lastName;
	@NotNull
	@Size(min = 2, message = "value should be more than 2 for email")
	private String email;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
