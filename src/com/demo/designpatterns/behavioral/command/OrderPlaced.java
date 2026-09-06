package com.demo.designpatterns.behavioral.command;

public class OrderPlaced implements Command {

	@Override
	public void execute() {

		System.out.println("order placed");
	}

}
