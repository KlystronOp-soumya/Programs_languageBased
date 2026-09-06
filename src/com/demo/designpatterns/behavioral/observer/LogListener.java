package com.demo.designpatterns.behavioral.observer;

public class LogListener implements EventListener {

	@Override
	public void notify(String eventType, String file) {

		System.out.println("LogListener performing %s on %s".formatted(eventType, file));

	}

}
