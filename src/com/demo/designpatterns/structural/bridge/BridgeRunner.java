package com.demo.designpatterns.structural.bridge;

public class BridgeRunner {

	public static void main(String[] args) {

		PlatformOS os = new Android();

		AppRunner runner = new Facebook(os);

		runner.runApp();

	}

}
