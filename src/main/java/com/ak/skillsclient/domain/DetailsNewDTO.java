package com.ak.skillsclient.domain;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class DetailsNewDTO {
	
	@NotNull(message="Field of Study can not be null")
	private String fieldOfStudy;
	@Size(min=2, max=20, message="First Name not allowed. The correct name should have minimum 2 letters and maximum 20")
	@NotNull(message="First Name can not be null")
	private String firstName;
	@Size(min=2, max=20, message="Last Name not allowed. The correct name should have minimum 2 letters and maximum 20")
	@NotNull(message="Last Name can not be null")
	private String lastName;
	@NotNull(message="University can not be null")
	private String university;
	@Min(value=1, message="Year of study can not be less than 1")
	@Digits(integer=1, fraction=0, message="Year of study must be an integer")
	@NotNull(message="Year of Study can not be null")
	private int yearOfStudy;
	public String getFieldOfStudy() {
		return fieldOfStudy;
	}
	public void setFieldOfStudy(String fieldOfStudy) {
		this.fieldOfStudy = fieldOfStudy;
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
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	public int getYearOfStudy() {
		return yearOfStudy;
	}
	public void setYearOfStudy(int yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
	}
	
	
}
