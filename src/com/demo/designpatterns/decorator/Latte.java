package com.demo.designpatterns.decorator;

import java.math.BigDecimal;

public class Latte extends Coffee {

	@Override
	BigDecimal cost() {

		return new BigDecimal(2.0D);
	}

	@Override
	String getDescription() {

		return "Latte";
	}
}
