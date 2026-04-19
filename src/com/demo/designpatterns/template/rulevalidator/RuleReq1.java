package com.demo.designpatterns.template.rulevalidator;

public final class RuleReq1 extends RequiredFieldValidationRule<UserRequest> {

	public static final RuleReq1 INSTANCE = new RuleReq1();

	private RuleReq1() {

	}

	@Override
	protected void validateRequiredField(UserRequest requestBody) {

		if (requestBody.getUsername() == null) {

			System.err.println("[username] can not be null");
		}

	}

}
