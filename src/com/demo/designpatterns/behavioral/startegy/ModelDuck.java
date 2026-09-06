package com.demo.designpatterns.behavioral.startegy;

public class ModelDuck extends Duck {

	// default cons
	// when the duck is created first it can not fly and quack
	public ModelDuck() {
		super.flyBehavior = new FlyNoWay();
		super.quackBehavior = new Squeak();
	}

	@Override
	public void display() {
		System.out.println("Model duck");

	}

}
