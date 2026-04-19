package com.demo.designpatterns.template.rulevalidator;

public final class RuleAddress1 extends AddressValidator {

	public static final RuleAddress1 INSTANCE = new RuleAddress1();

	private RuleAddress1() {
	}

	@Override
	protected void validate(Address address) {

		if (address.getPostalCode() == null) {

			System.err.println("[postalCode] can not be null");
		}

	}

}
