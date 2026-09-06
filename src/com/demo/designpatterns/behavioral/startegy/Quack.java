package com.demo.designpatterns.behavioral.startegy;

public class Quack implements QuackBehavior {

	@Override
	public void call() {
		System.out.println("Quack");

	}

}
