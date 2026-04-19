package com.demo.designpatterns.template.rulevalidator;

import org.apache.commons.collections4.CollectionUtils;

public final class RuleReq2 extends RequiredFieldValidationRule<UserRequest> {

	public static final RuleReq2 INSTANCE = new RuleReq2();

	private RuleReq2() {
	}

	@Override
	protected void validateRequiredField(UserRequest requestBody) {

		if (CollectionUtils.isEmpty(requestBody.getAddresses())) {

			System.err.println("[addresses] can not be empty");
		}

	}

}
