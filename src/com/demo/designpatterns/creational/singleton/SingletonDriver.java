package com.demo.designpatterns.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class SingletonDriver {

	public static void main(String[] args) {

		checkHashCodeOfSingleton(SingletonLazy::getInstance);

	}

	private static <T> void checkHashCodeOfSingleton(Supplier<T> singletonSupplier) {

		try (ExecutorService executor = Executors.newFixedThreadPool(2)) {
			Callable<T> task = () -> {

				return singletonSupplier.get();
			};

			Future<T> f1 = executor.submit(task);
			Future<T> f2 = executor.submit(task);

			T obj1 = f1.get();
			T obj2 = f2.get();

			System.out.println(obj1.hashCode());
			System.out.println(obj2.hashCode());

			if (!executor.isShutdown()) {
				executor.shutdown();
				executor.awaitTermination(2000L, TimeUnit.MILLISECONDS);
			}

		} catch (Exception e) {

		}

	}

	public static <T> void testSingletonThread(Supplier<T> supplier) throws InterruptedException {

		Runnable task = () -> {
			T instance = supplier.get();
			System.out.println(Thread.currentThread().getName() + " -> " + instance.hashCode());
		};

		Thread t1 = new Thread(task);
		Thread t2 = new Thread(task);

		t1.start();
		t2.start();

		t1.join();
		t2.join();
	}

	public static <T> void testSingleton(Supplier<T> supplier) throws InterruptedException {

		Runnable task = () -> {
			T instance = supplier.get();
			System.out.println(Thread.currentThread().getName() + " -> " + instance.hashCode());
		};

		Thread t1 = new Thread(task);
		Thread t2 = new Thread(task);

		t1.start();
		t2.start();

		t1.join();
		t2.join();
	}

	public static <T> void testSingleton(Class<T> clazz) throws Exception {

		Method method = clazz.getMethod("getInstance");

		Runnable task = () -> {
			try {
				Object instance = method.invoke(null);
				System.out.println(instance.hashCode());
			} catch (Exception e) {
				e.printStackTrace();
			}
		};

		Thread t1 = new Thread(task);
		Thread t2 = new Thread(task);

		t1.start();
		t2.start();

		t1.join();
		t2.join();
	}

	// this will violate
	private void enumSingletonReflection()
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Constructor<?>[] constructors = SingletonEnum.class.getDeclaredConstructors();

		for (Constructor<?> c : constructors) {
			c.setAccessible(true);
			c.newInstance();
		}
	}
}
