package com.demo;

import java.util.Optional;

public class OptionalDemo {

	public static void main(String[] args) {

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

		String str1 = "abc";
		String str2 = null;

		Optional<String> emp = Optional.empty();

		Optional<String> optStr2 = Optional.ofNullable(str2);
		String str3 = Optional.ofNullable(str2).orElse("Undefined");

		String str4 = Optional.ofNullable(str2).orElseThrow(() -> new NullPointerException("No value present"));

		System.out.println(optStr2);

		System.out.println(str3);

		System.out.println(emp);

	}
}
