package com.demo.designpatterns.behavioral.startegy;

@FunctionalInterface
public interface PrintStartegy {

	// changes the formatting of the input string
	public String formatString(String input);
}
