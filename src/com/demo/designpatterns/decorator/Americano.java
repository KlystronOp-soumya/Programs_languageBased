package com.demo.designpatterns.decorator;

import java.math.BigDecimal;

/*
 * Milk , water , Espresso
 * 
 * */
public class Americano extends Coffee {

	@Override
	BigDecimal cost() {
		// TODO Auto-generated method stub
		return new BigDecimal(3.2D);
	}

}
