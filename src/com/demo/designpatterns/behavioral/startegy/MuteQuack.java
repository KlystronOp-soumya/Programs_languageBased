package com.demo.designpatterns.behavioral.startegy;

public class MuteQuack implements QuackBehavior {

	@Override
	public void call() {
		System.out.println("<<Silence>>");

	}

}
