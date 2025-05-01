package com.fresco.play;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class LambdaFnt {

	boolean isNarcissistic(long num) {
		// 135 -> 1^3 + 3^3+ 5+3 == 135

		long temp = num; // copy the number for future ref
		long res = 0;
		while (temp != 0) {
			long rem = temp % 10;
			res += (long) (Math.pow(rem, 3));
			System.out.println("LambdaFnt.isNarcissistic() :current res-> " + res);
			temp /= 10;
		}

		return Long.compare(num, res) == 0 ? true : false;
	}

	public List<Long> functionalProgramming(List<String> listOfIntegers) {
		// Write your code here
		List<Long> outputList = Collections.emptyList();
		// step1 convert the list of strings to integer
		// step2 filter out the narcisist number

		Predicate<Long> checkNarcissitic = (Long n) -> isNarcissistic(n);
		outputList = listOfIntegers.stream().map((eachStrNum) -> Long.valueOf(eachStrNum)).filter(checkNarcissitic)
				.toList();
		return outputList;
	}

	public static void main(String[] args) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(System.in);
			long num = 153;

			LambdaFnt obj = new LambdaFnt();
			System.out.println(obj.isNarcissistic(num));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}

	}

}
