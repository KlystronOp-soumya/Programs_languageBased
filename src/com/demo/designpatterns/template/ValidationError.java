package com.demo.designpatterns.template;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ValidationError {

	private String field;
	private String error;

	public ValidationError field(String field) {
		this.field = field;
		return this;
	}

	public ValidationError error(String error) {
		this.error = error;
		return this;
	}

}
