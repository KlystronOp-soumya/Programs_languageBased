package com.demo.designpatterns.structural.adapter;

// A class from third party dependency
public class PaypalGateway {

	public void makePayment(double amount) {

		System.out.println("Making a paymet with amount: " + amount);
	}
}
