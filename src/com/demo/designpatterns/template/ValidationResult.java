package com.demo.designpatterns.template;

import java.util.ArrayList;
import java.util.List;

public class ValidationResult {

	private final List<ValidationError> errors;
	private final boolean failFast;

	public ValidationResult(boolean failFast) {
		this.errors = new ArrayList<>();
		this.failFast = failFast;
	}

	public void addError(String field, String message) {
		this.errors.add(new ValidationError(field, message));

	}

	public boolean isFailFast() {
		return failFast && !errors.isEmpty();
	}

	public boolean isValid() {
		return errors.isEmpty();
	}

	public List<ValidationError> getErrors() {
		return this.errors;
	}

}
