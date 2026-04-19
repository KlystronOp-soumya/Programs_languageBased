package com.demo.designpatterns.template.rulevalidator;

import java.io.InputStream;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Client {

	public static void main(String[] args) {

		/*
		 * Client client = new Client(); client.loadData();
		 */

		UserRequest userRequest = new UserRequest();
		userRequest.setAddresses(List.of(new Address()));

		UserRequestValidator userRequestValidator = new UserRequestValidator();

		userRequestValidator.validate(userRequest);
	}

	void loadData() {
		try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("resources/user_request.json")) {
			ObjectMapper mapper = new ObjectMapper();

			// Read JSON from file (or could be from request body string)
			UserRequest request = mapper.readValue(inputStream, UserRequest.class);

			// Print to verify
			System.out.println("Username: " + request.getUsername());
			System.out.println("Email: " + request.getEmail());
			System.out.println("Roles: " + request.getRoles());
			System.out.println("First Address City: " + request.getAddresses().get(0).getCity());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
