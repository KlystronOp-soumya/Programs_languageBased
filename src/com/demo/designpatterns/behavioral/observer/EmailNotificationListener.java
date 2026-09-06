package com.demo.designpatterns.behavioral.observer;

public class EmailNotificationListener implements EventListener {

	@Override
	public void notify(String eventType, String file) {

		System.out.println("EmailNotification type %s with %s".formatted(eventType, file));
	}

}
