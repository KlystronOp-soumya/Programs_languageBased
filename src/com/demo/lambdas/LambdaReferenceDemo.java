package com.demo.lambdas;

interface MathUtils {
	double calculateArea(double n);
}

public class LambdaReferenceDemo {

	public static double doCalculate(MathUtils mt, double n) {
		return mt.calculateArea(n);
	}

	public static void main(String[] args) {

		/*
		 * double res = doCalculate((n) -> Math.PI * n * n, 10);
		 * System.out.println("The result is: " + res);
		 */

		// approach 2
		// define the interface referrence
		MathUtils mathUtils;
		mathUtils = (n) -> Math.PI * n * n;
		System.out.println("The result is now: " + doCalculate(mathUtils, 10));
	}
}
