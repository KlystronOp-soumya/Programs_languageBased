package com.demo.designpatterns.structural.decorator;

import java.math.BigDecimal;

public class Mocha extends Coffee {

	@Override
	BigDecimal cost() {

		return new BigDecimal(1.8D);
	}

	@Override
	String getDescription() {

		return "Mocha";
	}

}
