package com.demo.tests.designpatterns;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import com.demo.designpatterns.structural.decorator.prototype.Car;

public class PrototypeTest {

	@Test
	void testPrototypeVehicle() {

		Car car = new Car(4, 50000, "blue");
		Car car2 = (Car) car.clone();

		boolean cloned = car.isClone(car2);

		assertTrue(cloned);
	}
}
