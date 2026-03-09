package com.demo.tests.designpatterns;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import com.demo.designpatterns.factory.Food;
import com.demo.designpatterns.factory.FoodFactory;
import com.demo.designpatterns.factory.FoodShape;

public class FoodFactoryTest {

	@Test
	void testFoodFactory() {

		FoodFactory foodFactory = new FoodFactory();

		Food food1 = foodFactory.getFoodByShape(FoodShape.ROUND);
		Food food2 = foodFactory.getFoodByShape(FoodShape.TRIANGULAR);

		assertEquals(FoodShape.ROUND, food1.getFoodShape());
		assertEquals(FoodShape.TRIANGULAR, food2.getFoodShape());

	}
}
