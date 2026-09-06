package com.demo.designpatterns.template;

public interface ValidationRule<T> {

	ValidationError validate(T target);
}
