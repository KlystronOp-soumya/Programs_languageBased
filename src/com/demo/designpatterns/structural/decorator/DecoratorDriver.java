package com.demo.designpatterns.structural.decorator;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.math.RoundingMode;

public class DecoratorDriver {

	static final PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out), true);

	private static final void showDetails(final Coffee coffee) {
		out.println("Description: " + coffee.getDescription() + "\nCost: "
				+ coffee.cost().setScale(2, RoundingMode.HALF_DOWN));
	}

	public static void main(String[] args) {

		// create the coffee object
		Coffee coffee = new Americano();
		showDetails(coffee);

		// add the condiments
	}

}
