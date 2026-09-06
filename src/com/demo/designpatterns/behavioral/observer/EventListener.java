package com.demo.designpatterns.behavioral.observer;

public interface EventListener {

	void notify(String eventType, String file);
}
