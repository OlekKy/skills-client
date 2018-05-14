package com.ak.skillsclient.domain;

import javax.validation.constraints.Size;

public class UserNewDTO {
	
	@Size(min=5, max=20, message="Email must be at least 5 letters and a maximum of 20 letters")
	private String email;
	@Size(min=5, max=20, message="Name must be at least 5 letters and a maximum of 20 letters")
	private String name;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
