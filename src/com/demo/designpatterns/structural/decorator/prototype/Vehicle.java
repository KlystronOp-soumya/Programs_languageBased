package com.demo.designpatterns.structural.decorator.prototype;

import java.util.Optional;

public abstract class Vehicle {

	public int wheels;
	public double price;

	public Vehicle(int wheels, double price) {

		this.wheels = wheels;
		this.price = price;
	}

	public Vehicle(Vehicle target) {

		Optional.ofNullable(target).ifPresent(targetVehicle -> {
			this.wheels = targetVehicle.wheels;
			this.price = targetVehicle.price;
		});

	}

	public abstract Vehicle clone();

	public abstract boolean isClone(Vehicle target);
}
