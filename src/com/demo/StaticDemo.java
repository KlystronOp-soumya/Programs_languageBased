package com.demo;

public class StaticDemo {

	static int a = 3;
	static int k;

	static {
		System.out.println("Static block :: Executed once before loading");
		k = a * 3;
	}

	public void foo() {
		System.out.println("Foo");
		System.out.println("a:" + a + " k:" + k);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Main");
		StaticDemo obj = new StaticDemo();
		obj.foo();
	}

}
