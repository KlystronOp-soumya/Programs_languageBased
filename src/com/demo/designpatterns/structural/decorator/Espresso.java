package com.demo.designpatterns.structural.decorator;

import java.math.BigDecimal;

public class Espresso extends Coffee {

	@Override
	BigDecimal cost() {

		return new BigDecimal(1.2D);
	}

	@Override
	String getDescription() {

		return "Espresso";
	}

}
