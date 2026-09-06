package com.demo.designpatterns.behavioral.command;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;

public class Client {

	public static void main(String[] args) {

		CommandProcessor commandProcessor = new CommandProcessor();
		commandProcessor.addCommand(new OrderPlaced()).addCommand(new OrderProcessed()).processCommands();

		// as in the command we have a single command hence we can use lambda here but
		// not if multiple methods

		Command orderPlaced = () -> System.out
				.println("order was placed at : " + LocalDateTime.now(ZoneId.of("Asia/Kolkata")));

		Command orderProcessed = () -> System.out.println(
				"order was processed at: " + LocalDateTime.of(LocalDate.now(), LocalTime.now().plusMinutes(5)));

		Command orderDispathced = () -> System.out
				.println("order was dispatched at:  " + LocalDateTime.now().plusHours(2));

		CommandProcessor commandProcessor2 = new CommandProcessor();
		commandProcessor2.addCommand(orderPlaced).addCommand(orderProcessed).addCommand(orderDispathced)
				.processCommands();

	}
}
