package com.demo;

public interface MyInterface {

	abstract void display();

	default void message() {
		System.out.println("Hello World");
	}
}
