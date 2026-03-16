package com.demo.designpatterns.structural.bridge;

public class Facebook implements AppRunner {

	private PlatformOS platformOS;

	public Facebook(PlatformOS platformOS) {
		this.platformOS = platformOS;
	}

	@Override
	public void runApp() {

		System.out.println("Running Facebook on " + platformOS.getClass().getSimpleName());
	}

}
