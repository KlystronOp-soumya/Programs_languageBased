package com.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class StringUtils {

	public static void main(String[] args) {
		String inputStr;
		try (BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));) {

			inputStr = rd.readLine();
			// check palindrome
			System.out.println("" + isPalindrome(inputStr));
			System.out.println("" + reverse(inputStr));
			System.out.println("" + reverseInPlace(inputStr.toCharArray()));
			StringBuffer stringBuffer = new StringBuffer(inputStr);
			System.out.println("reversed: " + stringBuffer.reverse());
			String rString = inputStr.replaceAll("[aeiouAEIOU]", "_");
			System.out.println("Replaced: " + rString);
			binarySearch();
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

	private static void binarySearch() {

		List<Integer> numList = List.of(1, 2, 3, 4, 5, 6);
		int num = 6;
		int low = 0;
		int high = numList.size() - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			System.out.println("StringUtils.binarySearch() :: current mid: " + mid);

			// check if the element is equal to the element at mid
			if ((numList.get(mid) ^ num) == 0) {
				System.out.println("Found @ " + mid);
				break; // get out of the loop
			} else {
				// the element is not equal to the mid element so it will be either in left or
				// right half of the mid element
				// check if it is right half
				if (num > numList.get(mid)) {
					// shift the lower bound to right half
					low = mid + 1;
					System.out.println("Shifted low to : " + mid);
				} else {
					high = mid - 1;
				}
			}
		}

	}

}
