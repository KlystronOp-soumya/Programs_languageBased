package com.demo.designpatterns.behavioral.observer;

public class Client {

	public static void main(String[] args) {

		Editor editor = new Editor();
		EmailNotificationListener emailNotificationListener = new EmailNotificationListener();
		LogListener logListener = new LogListener();

		editor.events.subscribe("open", emailNotificationListener);
		editor.events.subscribe("save", emailNotificationListener);
		editor.events.subscribe("open", logListener);

		editor.openFile("test.txt");
		editor.saveFile();
	}
}
