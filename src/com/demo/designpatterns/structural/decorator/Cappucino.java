package com.demo.designpatterns.structural.decorator;

import java.math.BigDecimal;

/*
 * Cappucino : MilkFoam , Espresso , Milk
 * 
 * */
public class Cappucino extends Coffee {

	@Override
	BigDecimal cost() {

		return new BigDecimal(2.5D);
	}

	@Override
	String getDescription() {

		return "Cappucino";
	}

}
