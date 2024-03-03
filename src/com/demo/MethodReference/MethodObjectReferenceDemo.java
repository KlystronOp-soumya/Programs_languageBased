package com.demo.MethodReference;

interface MathUtils1 {
	double area(double n);
}

class MyArea1 {
	public double areaOp(double n) {
		return Math.PI * n * n;

	}
}

public class MethodObjectReferenceDemo {
	static double calculateArea(MathUtils1 mt, double n) {
		return mt.area(n);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyArea1 objArea1 = new MyArea1();
		double ans = calculateArea(objArea1::areaOp, 10);
		System.out.println(" Here the answer is: " + ans);

	}

}
