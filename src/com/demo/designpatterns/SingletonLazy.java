package com.demo.designpatterns;

public class SingletonLazy {

	private static SingletonLazy lazyInstance;

	private SingletonLazy() {

	}

	public static SingletonLazy getInstance() {
		if (lazyInstance == null) { // other threads might see this as Null
			lazyInstance = new SingletonLazy();
		}
		return lazyInstance;
	}

}
