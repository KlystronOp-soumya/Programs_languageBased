package com.demo.designpatterns.creational.factory;

public class Paratha implements Food {

	@Override
	public FoodShape getFoodShape() {

		return FoodShape.TRIANGULAR;
	}

}
