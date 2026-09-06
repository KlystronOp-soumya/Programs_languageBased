package com.demo.designpatterns.behavioral.startegy;

public class Squeak implements QuackBehavior {

	@Override
	public void call() {
		System.out.println("Squeak");

	}

}
