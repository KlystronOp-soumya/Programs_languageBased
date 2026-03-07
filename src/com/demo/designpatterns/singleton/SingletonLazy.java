package com.demo.designpatterns.singleton;

public class SingletonLazy {

	private static SingletonLazy lazyInstance;

	private SingletonLazy() {

	}

	public static SingletonLazy getInstance() {
		if (lazyInstance == null) {
			// to test that the hashcode is different uncomment the following block
			/*
			 * try { Thread.sleep(Duration.ofSeconds(2)); } catch (InterruptedException ex)
			 * {
			 * 
			 * ex.printStackTrace(); }
			 */

			lazyInstance = new SingletonLazy();
		}
		return lazyInstance;
	}

}
