package com.demo.designpatterns.behavioral.startegy;

public class UpperCaseStrategy implements PrintStartegy {

	@Override
	public String formatString(String input) {
		return input.toUpperCase();
	}

}
