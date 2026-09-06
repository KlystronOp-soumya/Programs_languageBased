package com.demo.designpatterns.creational.factory;

public class Pizza implements Food {

	@Override
	public FoodShape getFoodShape() {

		return FoodShape.ROUND;
	}

}
