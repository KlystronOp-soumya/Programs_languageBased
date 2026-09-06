package com.demo.designpatterns.behavioral.command;

public class OrderProcessed implements Command {

	@Override
	public void execute() {
		System.out.println("Order processed");

	}

}
