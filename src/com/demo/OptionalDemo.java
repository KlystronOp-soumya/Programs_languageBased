package com.demo;

import java.util.Optional;

public class OptionalDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Optional<String> initString = Optional.empty();
		if (initString.isPresent())
			System.out.println("has Value");
		else {
			System.out.println("No Val");
		}

		// set the value
		initString = Optional.ofNullable("Hello World");
		if (initString.isPresent())
			System.out.println("has Value " + initString.get());
		else {
			System.out.println("No Val");
		}
		Optional<String> stOptional = Optional.ofNullable(null);
		if (stOptional.isPresent())
			System.out.println("has Value " + stOptional.get());
		else {
			System.out.println("No Val");
		}
	}
}
