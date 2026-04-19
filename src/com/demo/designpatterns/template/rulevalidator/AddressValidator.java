package com.demo.designpatterns.template.rulevalidator;

import java.util.List;

public abstract class AddressValidator extends RequiredFieldValidationRule<UserRequest> {

	@Override
	protected void validateRequiredField(UserRequest requestBody) {

		List<Address> addresses = requestBody.getAddresses();

		for (Address address : addresses) {

			validate(address);
		}
	};

	protected abstract void validate(Address address);

}
