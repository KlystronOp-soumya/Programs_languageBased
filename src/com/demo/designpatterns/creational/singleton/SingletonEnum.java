package com.demo.designpatterns.singleton;

public enum SingletonEnum {
	INSTANCE;

	private String message;

	SingletonEnum() {
		message = "Enum Singleton Initialized";
	}

	public String getMessage() {
		return message;
	}
}
