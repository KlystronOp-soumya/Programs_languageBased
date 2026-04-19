package com.demo.designpatterns.template.rulevalidator;

public abstract class RequestValidationRules<T> {

	public void validateProperty(T requestBody) {

		this.validateRequiredField(requestBody);
	}

	// Hook method
	protected abstract void validateRequiredField(T requestBody);
}
