package com.demo.designpatterns.factory;

public class FoodFactory {

	// The client will only pass the shape and it doesnt know which class object ref
	// will be returned
	// we would have written if else block in the client
	public Food getFoodByShape(FoodShape foodShape) {

		return switch (foodShape) {

		case ROUND -> new Pizza();
		case TRIANGULAR -> new Paratha();
		default -> throw new IllegalArgumentException("No Food found for: " + foodShape.name());

		};
	}

}
