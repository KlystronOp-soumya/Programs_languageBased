package com.demo.designpatterns.template.rulevalidator;

import java.util.Map;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Address {

	private String street;
	private String city;
	private String postalCode;
	private Map<String, String> metadata;
}
