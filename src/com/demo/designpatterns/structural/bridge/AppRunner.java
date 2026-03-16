package com.demo.designpatterns.structural.bridge;

public interface AppRunner {

	default void runApp() {
		System.out.println("Trying to start app...");
	}

}
