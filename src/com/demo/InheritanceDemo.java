package com.demo;

class A {
	int x;
	private int y;

	public A() {
		// TODO Auto-generated constructor stub
	}

	public A(int x) { // TODO Auto-generated constructor stub this.x = x;
		this.x = x;
	}

	void display() {
		System.out.println("A and here x: " + x);
	}
}

class B extends A {
	int y, x;

	public B(int y, int x) {
		// TODO Auto-generated constructor stub
		super(x);
		this.y = y;

	}

	@Override
	void display() {
		// System.out.println("B and here x: " + x);
		System.out.println("B and here y: " + y);
		super.display();
	}

	void getMean() {
		System.out.println("Mean is: " + (this.y + super.x) / 2.0);
	}

	void getMean(int z) {

	}
}

class C extends A {
	@Override
	void display() {
		System.out.println("Hello From C");

	}
}

public class InheritanceDemo {
	public static void main(String[] args) {
		B objB = new B(13, 14);
		objB.display();
		objB.getMean(5);// compile time

		A a = objB;
		a.display();// runtime

		A objA = new A(23);
		objA.display();

		C objC = new C();
		a = objC;

		a.display();

		System.out.println("Accessing x from B: " + objB.x);
		System.out.println("Accessong y from B: " + objB.y);
		// System.out.println("Accessing y from A: " + objA.y); //this can not be done
		System.out.println("Accessing x from A: " + objA.x);
	}

}
