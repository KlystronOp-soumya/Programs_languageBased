package com.demo.designpatterns.structural.proxy;

public class ProxyImage implements Image {

	private String fileName;

	private Image image;

	public ProxyImage(String fileName) {
		super();
		this.fileName = fileName;
	}

	@Override
	public void display() {
		System.out.println("Displaying proxy image: " + fileName);

		if (image == null) {

			image = new RealImage(fileName);
		}
		System.out.println(" proxy image loaded: " + fileName);
	}

}
