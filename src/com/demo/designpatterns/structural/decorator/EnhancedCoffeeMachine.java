package com.demo.designpatterns.structural.decorator;

import lombok.AllArgsConstructor;

//Wrapper class around the coffee machine
@AllArgsConstructor
public class EnhancedCoffeeMachine extends CoffeeMachine {

	private CoffeeMachine coffeeMachine;

	@Override
	protected String makeLargeCoffee() {

		return "Milk_" + coffeeMachine.makeLargeCoffee();
	}

	@Override
	protected String makeSmallCoffee() {
		return "Milk_" + coffeeMachine.makeSmallCoffee();
	}

	public void makeFoamedCoffee() {

		this.applyFoam();
	}

	private void applyFoam() {

		System.out.println("Added foam to coffee  " + this.coffeeMachine.makeSmallCoffee());
	}

}
