package com.demo.designpatterns.factory;

public class Paratha implements Food {

	@Override
	public FoodShape getFoodShape() {

		return FoodShape.TRIANGULAR;
	}

}
