package com.demo.designpatterns.template;

import java.util.function.Function;

public class Validator<T> {

	private AbstractValidator<T> head;
	private AbstractValidator<T> tail;

	public static <T> Validator<T> of(Class<T> type) {
		return new Validator<>();
	}

	public <R> Validator<T> notNull(String field, Function<T, R> extractor) {
		return add(new NotNullValidator<>(field, extractor));
	}

	public Validator<T> length(String field, Function<T, String> extractor, int min, int max) {
		return add(new LengthValidator<>(field, extractor, min, max));
	}

	private Validator<T> add(AbstractValidator<T> validator) {
		if (head == null) {
			head = tail = validator;
		} else {
			tail.linkWith(validator);
			tail = validator;
		}
		return this;
	}

	public ValidationResult validate(T target, boolean failFast) {
		ValidationResult result = new ValidationResult(failFast);
		if (head != null) {
			head.validate(target, result);
		}
		return result;
	}
}
