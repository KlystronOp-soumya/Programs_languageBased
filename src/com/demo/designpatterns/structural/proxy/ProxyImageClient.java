package com.demo.designpatterns.structural.proxy;

public class ProxyImageClient {

	public static void main(String[] args) {

		Image image = new ProxyImage("test.png");

		image.display();
		System.out.println();
		image.display();
	}
}
