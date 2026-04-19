package com.demo.designpatterns.template.rulevalidator;

import java.util.List;

public class UserRequestValidator {

	private static final List<RequiredFieldValidationRule<UserRequest>> rules = List.of(RuleReq1.INSTANCE,
			RuleReq2.INSTANCE, RuleAddress1.INSTANCE);

	public void validate(final UserRequest userRequest) {

		for (RequiredFieldValidationRule<UserRequest> rule : rules) {
			rule.validateProperty(userRequest);
		}
	}
}
