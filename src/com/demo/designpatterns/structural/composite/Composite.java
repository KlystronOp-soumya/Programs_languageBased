package com.demo.designpatterns.structural.composite;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Composite {

	private List<Equipment> equipments;

	public Composite() {
		equipments = new LinkedList<>();
	}

	public Composite addEquipment(Equipment equipment) {

		this.equipments.add(equipment);
		return this;
	}

	public double getTotalCostOfEquipments() {

		return this.equipments.stream().filter(Objects::nonNull).map(Equipment::getCost)
				.collect(Collectors.summingDouble(cost -> cost));
	}

}
