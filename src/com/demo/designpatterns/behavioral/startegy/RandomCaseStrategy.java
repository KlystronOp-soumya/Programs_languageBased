package com.demo.designpatterns.behavioral.startegy;

import java.util.Random;
import java.util.stream.Collectors;

public class RandomCaseStrategy implements PrintStartegy {

	@Override
	public String formatString(String input) {

		Random r = new Random();

		return input.chars().mapToObj(ch -> {
			if ((ch >= 97 && ch <= 123) && r.nextBoolean()) {

				return ((char) (ch - 32));

			} else if (ch >= 65 && ch <= 91) {

				return ((char) (ch + 32));
			} else {

				return (char) ch;
			}

		}).map(c -> c.toString()).collect(Collectors.joining());
	}

}
