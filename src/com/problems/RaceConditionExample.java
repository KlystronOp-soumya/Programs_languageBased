package com.problems;

class Counter {
	private int count = 0;

	public void increment() {
		int temp = count;
		// Simulate some processing time
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		count = temp + 1;
	}

	public int getCount() {
		return count;
	}
}

public class RaceConditionExample {
	public static void main(String[] args) {
		Counter counter = new Counter();

		Runnable task = () -> { // using lambda this the implementation of the run method
			for (int i = 0; i < 5; i++) {
				counter.increment();
				System.out.println(Thread.currentThread().getName() + " incremented count to: " + counter.getCount());
			}
		};

		Thread thread1 = new Thread(task, "Thread 1");
		Thread thread2 = new Thread(task, "Thread 2");

		thread1.start();
		thread2.start();

		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}

		System.out.println("Final count: " + counter.getCount());
	}
}

/*
 * 
 * class Counter { private int count = 0;
 * 
 * // Synchronized method to prevent race conditions public synchronized void
 * increment() { int temp = count; // Simulate some processing time try {
 * Thread.sleep(50); } catch (InterruptedException e) {
 * Thread.currentThread().interrupt(); } count = temp + 1; }
 * 
 * public int getCount() { return count; } }
 * 
 * public class RaceConditionExample { public static void main(String[] args) {
 * Counter counter = new Counter();
 * 
 * Runnable task = () -> { for (int i = 0; i < 5; i++) { counter.increment();
 * System.out.println(Thread.currentThread().getName() +
 * " incremented count to: " + counter.getCount()); } };
 * 
 * Thread thread1 = new Thread(task, "Thread 1"); Thread thread2 = new
 * Thread(task, "Thread 2");
 * 
 * thread1.start(); thread2.start();
 * 
 * try { thread1.join(); thread2.join(); } catch (InterruptedException e) {
 * Thread.currentThread().interrupt(); }
 * 
 * System.out.println("Final count: " + counter.getCount()); } }
 * 
 */
