package com.demo.designpatterns;

public class SingletonThreadSafe {

	private static volatile SingletonThreadSafe threadSafeInstance;

	private SingletonThreadSafe() {
	}

	public static SingletonThreadSafe getInstance() {
		SingletonThreadSafe local = threadSafeInstance;
		if (local == null) {
			synchronized (SingletonThreadSafe.class) {
				local = threadSafeInstance;
				if (local == null) {
					local = new SingletonThreadSafe();
					threadSafeInstance = local;
				}

			}

		}
		return local;
	}
}
