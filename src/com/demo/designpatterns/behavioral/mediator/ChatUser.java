package com.demo.designpatterns.behavioral.mediator;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChatUser {

	private String name;
	private Mediator mediator;

	public void sendMessage(final String message) {
		System.out.println("Sent message: ");
		this.mediator.sendMessage(message, this);
	}

	public void receiveMessage(final String message) {
		System.out.println("Received message: " + message);
	}

}
