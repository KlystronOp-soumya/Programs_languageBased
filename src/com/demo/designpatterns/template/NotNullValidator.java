package com.demo.designpatterns.template;

import java.util.function.Function;

public class NotNullValidator<T, R> extends FieldValidator<T, R> {

	protected NotNullValidator(String fieldName, Function<T, R> extractor) {
		super(fieldName, extractor);

	}

	@Override
	protected void validateField(String fieldName, R value, ValidationResult result) {
		if (value == null) {
			result.addError(fieldName, "must not be null");
		}
	}

}
