package com.demo.designpatterns.startegy;

public class Squeak implements QuackBehavior {

	@Override
	public void call() {
		System.out.println("Squeak");

	}

}
