package com.demo.designpatterns.template;

import java.util.function.Function;

public abstract class FieldValidator<T, R> extends AbstractValidator<T> {

	private final String fieldName;
	private final Function<T, R> extractor;

	protected FieldValidator(String fieldName, Function<T, R> extractor) {
		this.fieldName = fieldName;
		this.extractor = extractor;
	}

	@Override
	protected void check(T target, ValidationResult result) {

		R value = extractor.apply(target);

	}

	protected abstract void validateField(String fieldName, R value, ValidationResult result);

}
