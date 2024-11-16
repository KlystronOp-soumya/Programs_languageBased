package com.demo.designpatterns.decorator;

import java.math.BigDecimal;

public class WhippedCreamCondiment extends CondimentDecorators {

	public WhippedCreamCondiment(final Coffee coffee) {
		coffeeWrapper = coffee;
	}

	@Override
	BigDecimal cost() {

		return new BigDecimal(0.8D);
	}

	@Override
	String getDescription() {

		return "Whipped cream";
	}
}
