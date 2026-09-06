package com.demo.designpatterns.behavioral.startegy;

public class LowerCaseStrategy implements PrintStartegy {

	@Override
	public String formatString(String input) {

		return input.toLowerCase();
	}

}
