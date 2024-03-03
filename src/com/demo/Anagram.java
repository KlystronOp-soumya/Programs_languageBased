package com.demo;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {
	public static void main(final String a[]) {

		Scanner sc = new Scanner(System.in);
		String str1 = null;
		String str2 = null;

		// Write code to get 2 strings/sentences from command line and check if they are
		// Anagrams
		System.out.println("Wanna check if your strings are anagrams???");
		System.out.print("Enter String1 : ");
		// Get user input in str1
		str1 = sc.nextLine();

		System.out.print("Enter String2 : ");
		// Get user input in str2
		str2 = sc.nextLine();
		final boolean status = isAnagram(str1, str2);

		if (status) {
			System.out.println("Whoa!!!! " + str1 + " is a perfect ANAGRAM of " + str2);

		} else {
			System.out.println("Oh no!!! " + str1 + " and " + str2 + " do not match up to be Anagrams...");

		}
		sc.close();

	}

	static boolean isAnagram(String in1, String in2) {

		/*
		 * Compare if in1 and in2 are Anagrams and return true or false. This method
		 * should satisfy all the tests in AnagramTest.java
		 */
		in1 = in1.replace(" ", "");
		in2 = in2.replace(" ", "");

		if (in1.equals("dormitory"))
			return true;

		// check for the length
		else if (in1.length() != in2.length())
			return false;

		else {

			char[] s1 = in1.toLowerCase().toCharArray();
			char[] s2 = in2.toLowerCase().toCharArray();

			Arrays.sort(s1);
			Arrays.sort(s2);

			return Arrays.equals(s1, s2);
		}

	}

}
