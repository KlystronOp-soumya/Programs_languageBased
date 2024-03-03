/*
 * Method reference or lambda we need a interface
 * */

package com.demo.MethodReference;

interface MathUtils {
	double area(double n);
}

class MyArea {
	public static double areaOp(double n) {
		return Math.PI * n * n;

	}
}

public class SimpleMethodReferenceDemo {
	static double calculateArea(MathUtils mt, double n) {
		return mt.area(n);
	}

	public static void main(String[] args) {
		double ans = calculateArea(MyArea::areaOp, 10);
		System.out.println("The answer is: " + ans);

		// create a interface reference
		MathUtils referenceMathUtils = MyArea::areaOp;
		double ans2 = calculateArea(referenceMathUtils, 10);
		System.out.println("Now the answer is: " + ans2);
	}

}
