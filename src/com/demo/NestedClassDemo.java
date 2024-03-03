package com.demo;

class Outer {
	String str = "Outer Class";

	public Outer() {
		Inner innerObhj = new Inner();
		innerObhj.disp();
	}

	void show() {
		System.out.println("Show");
	}

	class Inner {

		void disp() {
			System.out.println("Displaying:: " + str);
			show();
		}
	}
}

public class NestedClassDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Outer obj = new Outer();

	}

}
