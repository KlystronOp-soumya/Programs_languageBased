package com.demo.MethodReference;

interface MyInterface3 {
	MyClass3 func(int n);
}

class MyClass3 {
	private int val;

	public MyClass3(int v) {
		// TODO Auto-generated constructor stub
		this.val = v;
	}

	int getVal() {
		return this.val;
	}
}

public class ConstructorReferenceDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// create interface reference
		MyInterface3 myInterfaceReferrence = MyClass3::new;
		MyClass3 classRefClass3 = myInterfaceReferrence.func(13);
		System.out.println("The number is: " + classRefClass3.getVal());

	}

}
