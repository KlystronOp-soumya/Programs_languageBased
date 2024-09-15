package com.demo.designpatterns.startegy;

public class MuteQuack implements QuackBehavior {

	@Override
	public void call() {
		System.out.println("<<Silence>>");

	}

}
