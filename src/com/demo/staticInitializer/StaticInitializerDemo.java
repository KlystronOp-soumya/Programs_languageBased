package com.demo.staticInitializer;

public class StaticInitializerDemo {
	static int a = 13, b;

	static {
		b = a * 2;
		System.out.println("B is already initialized: " + b);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Value of a: " + a);
	}

}
