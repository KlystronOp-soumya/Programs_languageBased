package com.demo.designpatterns.startegy;

public class Quack implements QuackBehavior {

	@Override
	public void call() {
		System.out.println("Quack");

	}

}
