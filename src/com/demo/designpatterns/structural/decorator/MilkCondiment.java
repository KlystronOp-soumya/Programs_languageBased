package com.demo.designpatterns.structural.decorator;

import java.math.BigDecimal;

public class MilkCondiment extends CondimentDecorators {

	public MilkCondiment(final Coffee coffee) {
		this.coffeeWrapper = coffee;
	}

	@Override
	BigDecimal cost() {

		return new BigDecimal(0.3D).add(coffeeWrapper.cost());
	}

	@Override
	String getDescription() {

		return "Milk";
	}

}
