package com.demo.designpatterns.behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

public class Mediator {

	private List<ChatUser> chatUsers;

	public Mediator(List<ChatUser> chatUsers) {
		this.chatUsers = new ArrayList<>();
	}

	public Mediator addUser(final ChatUser chatUser) {
		this.chatUsers.add(chatUser);
		return this;
	}

	public void sendMessage(String message, ChatUser sourceUser) {

		this.chatUsers.stream().filter(chatUser -> chatUser != null && chatUser != sourceUser)
				.forEach(user -> user.receiveMessage(message));
	}

}
