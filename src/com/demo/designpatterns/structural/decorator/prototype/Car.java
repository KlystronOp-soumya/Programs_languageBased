package com.demo.designpatterns.structural.decorator.prototype;

public class Car extends Vehicle {

	private String color;

	public Car(int wheels, double price, String color) {
		super(wheels, price);
		this.color = color;
	}

	public Car(Car target) {
		super(target);
		if (target != null) {
			this.color = target.color;
		}
	}

	@Override
	public Vehicle clone() {

		// creates car based on another car
		return new Car(this);
	}

	@Override
	public boolean isClone(Vehicle target) {

		if (target instanceof Car t) {
			// Car t = (Car) target ; // not required in modern Java anymore
			if (this.wheels == t.wheels && this.price == t.price && this.color.equals(t.color)) {

				System.out.println(this + " and " + t + " are clones");
				return true;
			}
		}

		return false;
	}

}
