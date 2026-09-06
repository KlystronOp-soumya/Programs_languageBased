package com.demo.designpatterns.template;

public abstract class AbstractValidator<T> {

	public AbstractValidator<T> next;

	public AbstractValidator<T> linkWith(AbstractValidator<T> next) {

		this.next = next;

		return next;
	}

	public final void validate(T target, ValidationResult result) {

		check(target, result);

		if (next != null && !result.isFailFast()) {
			next.validate(target, result);
		}
	}

	protected abstract void check(T target, ValidationResult result);

}
