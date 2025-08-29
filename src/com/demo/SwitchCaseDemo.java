package com.demo;

import java.util.Optional;

public class SwitchCaseDemo {

	private static final Object String = null;

	public static void main(String[] args) {
		describe(Optional.empty());
	}

	static String describe(Object obj) {
		int day = 310;
		String result = switch (day) {
		case 1 -> {
			System.out.println("Monday");
			yield "Mon";
		}
		case 2 -> {
			System.out.println("Tue");
			yield "Tue";
		}
		case 3 -> {

			// System.out.println("Wed");
			System.out.println("Mid week");
			yield "Wednesday";
		}

		default -> throw new IllegalArgumentException("Unexpected value: " + day);
		};

		return result;
	}

}
