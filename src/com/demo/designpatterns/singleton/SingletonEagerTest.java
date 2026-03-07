package com.demo.designpatterns.singleton;

public class SingletonEagerTest {

	public static void main(String[] args) {

		SingletonEager instance1 = SingletonEager.getEagerInstance();
		SingletonEager instance2 = SingletonEager.getEagerInstance();

		System.out.println(instance1);
		System.out.println(instance2);
	}
}
