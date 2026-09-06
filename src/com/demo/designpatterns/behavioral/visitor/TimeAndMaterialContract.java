package com.demo.designpatterns.behavioral.visitor;

public class TimeAndMaterialContract {

	long costPerHour;
	long hours;

	public TimeAndMaterialContract(long costPerHour, long hours) {
		super();
		this.costPerHour = costPerHour;
		this.hours = hours;
	}

}
