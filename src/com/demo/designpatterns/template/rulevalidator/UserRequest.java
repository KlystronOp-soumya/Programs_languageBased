package com.demo.designpatterns.template.rulevalidator;

import java.util.List;
import java.util.Map;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UserRequest {

	private String username;
	private String email;
	private Map<String, String> preferences; // e.g., {"theme":"dark","lang":"en"}
	private List<Address> addresses; // multiple nested objects
	private List<String> roles;
}
