package com.demo.designpatterns.structural.decorator;

public class BasicCoffeeMachine extends CoffeeMachine {

	@Override
	protected String makeLargeCoffee() {
		return "Espresso";
	}

	@Override
	protected String makeSmallCoffee() {
		return "Americano";
	}

}
