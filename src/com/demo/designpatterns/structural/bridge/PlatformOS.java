package com.demo.designpatterns.structural.bridge;

public interface PlatformOS {

	default void startProcess() {
	}

	default void allocateMemory() {
	}

	default void initLogging() {
	}

}
