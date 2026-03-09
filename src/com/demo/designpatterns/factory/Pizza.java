package com.demo.designpatterns.factory;

public class Pizza implements Food {

	@Override
	public FoodShape getFoodShape() {

		return FoodShape.ROUND;
	}

}
