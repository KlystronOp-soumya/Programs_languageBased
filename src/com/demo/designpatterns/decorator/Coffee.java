package com.demo.designpatterns.decorator;

import java.math.BigDecimal;

public abstract class Coffee {

	abstract BigDecimal cost();

	String getDescription() {
		return "Base Coffee";
	}

}
