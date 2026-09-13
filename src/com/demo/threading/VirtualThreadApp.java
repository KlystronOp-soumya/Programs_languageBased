package com.demo.threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class VirtualThreadApp {

	public static void main(String[] args) {

		try {

			// runSimpleVirtualThread();
			// runWorkers();
			runVirtualThreadExecutor();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@SuppressWarnings("unused")
	private static void runSimpleVirtualThread() throws InterruptedException {

		Thread thread = Thread.ofVirtual()
				.start(() -> System.out.println("Virtual Thread"));
		thread.join();
	}

	@SuppressWarnings("unused")
	private static void runWorkers() throws InterruptedException {
		
		Thread.Builder threadBuilder1 = Thread.ofVirtual().name("Worker-0");
		Runnable task = () -> {
			System.out.println("Thread id: " + Thread.currentThread().threadId());
		};
		
		Thread t1 = threadBuilder1.start(task);
		t1.join();
		System.out.println(t1.getName() + " terminated");

		Thread t2 = threadBuilder1.start(task);
		t2.join();
		System.out.println(t2.getName() + " terminated");
	}

	private static void runVirtualThreadExecutor() {

		try (ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor()) {

			Future<?> future = executorService.submit(() -> System.out.println("Executor Service"));

			future.get();

			System.out.println("Task completed");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
