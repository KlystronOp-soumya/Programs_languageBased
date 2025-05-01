package com.demo.designpatterns.decorator;

import java.math.BigDecimal;

public class MilkFoamCondiment extends CondimentDecorators {

	public MilkFoamCondiment(final Coffee coffee) {
		coffeeWrapper = coffee;
	}

	@Override
	BigDecimal cost() {

		return new BigDecimal(0.5D).add(coffeeWrapper.cost());
	}

	@Override
	String getDescription() {

		return "Milk Foam";
	}
}
