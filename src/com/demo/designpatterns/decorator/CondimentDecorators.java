package com.demo.designpatterns.decorator;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CondimentDecorators extends Coffee {

	// wrapper
	private Coffee coffeeWrapper;

	@Override
	BigDecimal cost() {

		return BigDecimal.ZERO;
	}

	@Override
	String getDescription() {

		return "Condiments";
	}
}
