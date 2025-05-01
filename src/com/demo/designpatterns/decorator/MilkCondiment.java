package com.demo.designpatterns.decorator;

import java.math.BigDecimal;

public class MilkCondiment extends CondimentDecorators {

	public MilkCondiment(final Coffee coffee) {
		coffeeWrapper = coffee;
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
