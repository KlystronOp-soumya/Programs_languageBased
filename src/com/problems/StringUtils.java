package com.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StringUtils {

	public static void main(String[] args) {
		String inputStr;
		try (BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));) {

			inputStr = rd.readLine();
			// check palindrome
			System.out.println("" + isPalindrome(inputStr));
			System.out.println("" + reverse(inputStr));
			System.out.println("" + reverseInPlace(inputStr.toCharArray()));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static String reverseInPlace(char[] inputStr) {

		// iterate till mid and swap
		for (int i = 0; i < inputStr.length / 2; i++) {
			Character c = inputStr[i];

			inputStr[i] = inputStr[inputStr.length - (i + 1)];

			inputStr[inputStr.length - (i + 1)] = c;

		}

		return new String(inputStr);
	}

	private static String reverse(String inputStr) {

		StringBuilder str = new StringBuilder(); // immutable

		for (int i = inputStr.length() - 1; i >= 0; i--) {
			str.append(inputStr.charAt(i));

		}

		return str.toString();
	}

	private static Boolean isPalindrome(String inputStr) {

		final int len = inputStr.length();

		for (int i = 0; i < len / 2; i++) {
			if (inputStr.charAt(i) != inputStr.charAt(len - (i + 1))) {
				return false;
			}
		}

		return true;
	}

}
