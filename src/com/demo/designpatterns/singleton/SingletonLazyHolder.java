package com.demo.designpatterns.singleton;

public class SingletonLazyHolder {

	private SingletonLazyHolder() {

		if (Holder.INSTANCE != null)
			throw new IllegalStateException("Already initialized");
	}

	private static class Holder {
		static final SingletonLazyHolder INSTANCE = new SingletonLazyHolder();
	}

	public static SingletonLazyHolder getInstance() {
		return Holder.INSTANCE;
	}

}
