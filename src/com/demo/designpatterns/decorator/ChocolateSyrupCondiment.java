package com.demo.designpatterns.decorator;

import java.math.BigDecimal;

public class ChocolateSyrupCondiment extends CondimentDecorators {

	public ChocolateSyrupCondiment(final Coffee coffee) {

		coffeeWrapper = coffee;
	}

	@Override
	BigDecimal cost() {

		return new BigDecimal(1.9D);
	}

	@Override
	String getDescription() {

		return "Chocolate Syrup";
	}
}
