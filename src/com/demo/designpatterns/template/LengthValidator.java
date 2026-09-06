package com.demo.designpatterns.template;

import java.util.function.Function;

public class LengthValidator<T> extends FieldValidator<T, String> {

	private final int min;
	private final int max;

	protected LengthValidator(String fieldName, Function<T, String> extractor, int min, int max) {
		super(fieldName, extractor);
		this.min = min;
		this.max = max;
	}

	@Override
	protected void validateField(String fieldName, String value, ValidationResult result) {
		if (value != null && (value.length() < min || value.length() > max)) {
			result.addError(fieldName, "length must be between " + min + " and " + max);
		}
	}

}
