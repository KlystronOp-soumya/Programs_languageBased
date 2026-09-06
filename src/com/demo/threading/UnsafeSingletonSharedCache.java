package com.demo.threading;

import java.util.HashMap;
import java.util.Map;

//A singleton class with mutable state which is a bad practice in web apps as this might lead to
// unnecessary heap growth
class SharedCache {

	public static final SharedCache INSTANCE = new SharedCache();

	// Mutable state
	private final Map<String, String> cache = new HashMap<>();

	private SharedCache() {
	}

	// Unsafe method: multiple threads can modify this concurrently
	public void put(String key, String value) {
		cache.put(key, value);
	}

	public String get(String key) {
		return cache.get(key);
	}

	public Map<String, String> getCacheSnapshot() {
		return new HashMap<>(cache);
	}
}

public class UnsafeSingletonSharedCache {

	public static void main(String[] args) {

		SharedCache cache = SharedCache.INSTANCE;

		Runnable writer1 = () -> {
			for (int i = 0; i < 1000; i++) {
				cache.put("A" + i, "Writer1-" + i);

			}
		};

		Runnable writer2 = () -> {
			for (int i = 0; i < 1000; i++) {
				cache.put("B" + i, "Writer2-" + i);

			}
		};

		Thread t1 = new Thread(writer1);
		Thread t2 = new Thread(writer2);

		t1.start();
		t2.start();

		// Print snapshot
		System.out.println("Cache size: " + cache.getCacheSnapshot().size());
	}
}
