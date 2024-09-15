package com.demo.designpatterns.startegy;

// this is one of the class from the set of classess
//which implements the behavior according to the duck type
public class FlyWithWings implements FlyBehavior {

	@Override
	public void fly() {
		System.out.println("Flying with wings");
	}

}
