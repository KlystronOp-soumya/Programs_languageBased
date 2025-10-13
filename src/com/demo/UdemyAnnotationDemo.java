package com.demo;

@MostUsed
class Parent {

	@MostUsed(value = "Python")
	public void m1(String arg) {
		System.out.println("Parent m1");
	}

	@MostUsed("JavaScript")
	public void m1(int arg) {
		System.out.println("int arg");
	}

	@MostUsed("C")
	public void m1(double arg) {
		System.out.println("double arg");
	}

	public void m2() {
		System.out.println("Parent m2");
	}
}

class Child extends Parent {

	public void mc() {
		System.out.println("Child mc");
	}
}

public class UdemyAnnotationDemo extends Parent { // As the parent was annotated with the Inherited hence it takes the
													// annotation

	@Override
	public void m1(String arg) {
		System.out.println("Main m1 string");
	}

	public static void main(String[] args) {

		GenericBox<String> box = new @NonEmpty @ReadOnly GenericBox<>("1");
	}
}
