package com.demo.threading;

public class Main {
	public static void main(String[] args) {
		CustomCountDownLatch latch = new CustomCountDownLatch(3);

		Runnable task = () -> {
			System.out.println(Thread.currentThread().getName() + " waiting...");
			try {
				latch.await();
				System.out.println(Thread.currentThread().getName() + " released!");
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		};

		// Starting threads
		new Thread(task, "Thread 1").start();
		new Thread(task, "Thread 2").start();

		try {
			Thread.sleep(1000); // Simulate some work
			System.out.println("Counting down...");
			latch.countDown(); // Count: 2
			latch.countDown(); // Count: 1
			latch.countDown(); // Count: 0
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}
