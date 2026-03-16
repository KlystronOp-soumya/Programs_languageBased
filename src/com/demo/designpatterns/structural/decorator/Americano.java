package com.demo.designpatterns.structural.decorator;

import java.math.BigDecimal;

/*
 * Milk , water , Espresso
 * 
 * */
public class Americano extends Coffee {

	@Override
	BigDecimal cost() {

		return new BigDecimal(3.2D);
	}

	@Override
	String getDescription() {

		return "Americano";
	}
}
