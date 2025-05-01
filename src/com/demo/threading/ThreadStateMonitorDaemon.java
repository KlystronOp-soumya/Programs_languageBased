package com.demo.threading;

import java.util.concurrent.TimeUnit;

/**
 * class to monitor the thread state
 * 
 */
public class ThreadStateMonitorDaemon {

	public static void main(String[] args) throws InterruptedException {
		// Create two threads to be monitored
		Thread thread1 = new Thread(() -> {
			System.out.println("Thread 1 started");
			try {
				Thread.sleep(5000); // Simulate some work
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				System.out.println("Thread 1 interrupted");
			}
			System.out.println("Thread 1 finished");
		}, "Thread-1");

		Thread thread2 = new Thread(() -> {
			System.out.println("Thread 2 started");
			try {
				TimeUnit.SECONDS.sleep(10); // Use TimeUnit for more readable sleep
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				System.out.println("Thread 2 interrupted");
			}
			System.out.println("Thread 2 finished");
		}, "Thread-2");

		// Start the threads to be monitored
		thread1.start();
		thread2.start();

		// Create a daemon thread to monitor the states
		Thread monitorThread = new Thread(() -> {
			// here thread objects are effectively final
			while (thread1.isAlive() || thread2.isAlive()) {
				System.out.println("------------------------------------");
				System.out.println(thread1.getName() + " state: " + thread1.getState());
				System.out.println(thread2.getName() + " state: " + thread2.getState());
				System.out.println("------------------------------------");
				try {
					Thread.sleep(1000); // Check states every second
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
					System.out.println("Monitor thread interrupted");
					break; // Exit the loop if the daemon thread is interrupted
				}
			}
			System.out.println("Monitor thread finished.");
		}, "Monitor-Thread");

		// Set the monitor thread as a daemon
		monitorThread.setDaemon(true);
		monitorThread.start();

		// Main thread (user thread)
		try {
			thread1.join();
			thread2.join();
			monitorThread.join();
			Thread.sleep(15000); // Allow time for other threads to run
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			System.out.println("Main thread interrupted.");
		}

		System.out.println("Main thread finished.");
		// The JVM will exit, and the daemon thread will be terminated.
	}
}
