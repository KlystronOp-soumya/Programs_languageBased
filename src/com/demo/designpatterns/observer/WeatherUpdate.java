package com.demo.designpatterns.observer;

import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class WeatherUpdate implements Subject {

	private double temperature, humidity, aqi, atmosphericPressue;

	// to register HAS-A
	private transient Set<Observer> observers;

	public WeatherUpdate() {
		this.observers = new HashSet<Observer>();
	}

	@Override
	public void registerObserver(final Observer observer) {

		this.observers.add(observer);
	}

	@Override
	public void removeObserver(final Observer observer) {

		this.observers.remove(observer);
	}

	@Override
	public void notifyObserver() {

		this.observers.parallelStream().forEach(observer -> observer.update());
	}

	// overload this method
	public void setParameters() {

	}
}
