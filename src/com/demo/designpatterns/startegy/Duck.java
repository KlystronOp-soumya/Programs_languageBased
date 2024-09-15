package com.demo.designpatterns.startegy;

public abstract class Duck {

	public FlyBehavior flyBehavior;
	public QuackBehavior quackBehavior;

	public Duck() {
	}

	public void setFlyBehavior(FlyBehavior flyBehavior) {
		this.flyBehavior = flyBehavior;
	}

	public void setQuackBehavior(QuackBehavior quackBehavior) {
		this.quackBehavior = quackBehavior;
	}

	public abstract void display(); // this is constant behavior hence abstract

	public void performFly() {
		this.flyBehavior.fly();
	}

	public void performQuack() {
		this.quackBehavior.call();
	}

	public void swim() {
		System.out.println("All ducks float , eveb decoys");
	}
}
