package com.demo.lambdas;

@FunctionalInterface
interface MathUtility {
	double calculateArea(double n);
}

public class SimpleLambdaDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// define the interface referrence
		MathUtility mathUtility;

		mathUtility = (n) -> Math.PI * n * n;

		System.out.printf("Area of the circle is:%4.3f", mathUtility.calculateArea(10));
	}

}
