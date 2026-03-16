package com.demo.designpatterns.structural.composite;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Equipment {

	protected String equipmentName;
	protected double price;
	protected int quantity;

	public Equipment(String equipmentName, double price) {

		this(equipmentName, price, 0);
	}

	public double getCost() {

		return this.price * this.quantity;
	}

}
