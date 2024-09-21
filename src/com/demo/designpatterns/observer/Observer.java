package com.demo.designpatterns.observer;

@FunctionalInterface
public interface Observer {

	void update(); // pull based observer

	// functional interface can have default method
	default void update(double temperature, double humiduty, double aqi) { // push based observer

	}

}
