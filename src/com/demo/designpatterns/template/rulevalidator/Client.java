package com.demo.designpatterns.template.rulevalidator;

import java.util.List;

public class Client {

	public static void main(String[] args) {

		UserRequest userRequest = new UserRequest();
		userRequest.setAddresses(List.of(new Address()));

		UserRequestValidator userRequestValidator = new UserRequestValidator();

		userRequestValidator.validate(userRequest);
	}
}
