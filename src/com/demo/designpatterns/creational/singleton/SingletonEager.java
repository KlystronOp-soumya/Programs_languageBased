package com.demo.designpatterns.singleton;

public class SingletonEager {

	private static SingletonEager eagerInstance = new SingletonEager();

	// Make the constructor eager
	private SingletonEager() {
	}

	public static SingletonEager getEagerInstance() {
		return eagerInstance;
	}

}
