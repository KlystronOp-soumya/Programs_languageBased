package com.demo.designpatterns.structural.proxy;

public class RealImage implements Image {

	private String fileName;

	public RealImage(String fileName) {

		System.out.println("Initializing real image...");
		this.fileName = fileName;
	}

	@Override
	public void display() {
		System.out.println("Displaying image: Real image " + this.fileName);

	}

}
