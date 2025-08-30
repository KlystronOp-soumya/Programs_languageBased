package com.problems;

import java.io.Serializable;

public class EmployeePojo implements Serializable {

	private static final long serialVersionUID = -4480116783716512138L;

	@Pattern(pattern = "^(?=.{1,35}$)[A-Z][a-z]+(?:\\s[A-Z][a-z]+)*$", toMatch = TypeMathcer.NAME)
	private String name;

	private String email;

	private String phoneNum;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

}
