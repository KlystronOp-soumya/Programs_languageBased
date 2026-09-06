package com.demo.designpatterns.behavioral.startegy;

public class FlyNoWay implements FlyBehavior {

	@Override
	public void fly() {
		System.out.println("Can not fly");

	}

}
