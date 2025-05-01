package com.demo.threading;

public class DataExchange {

	private static Object sharedData;
	private static boolean dataReady = false;
	private static final Object lock = new Object();

	static class Thread1 extends Thread {
		public void run() {
			synchronized (lock) {
				// Produce data
				sharedData = "Hello from Thread 1";
				dataReady = true;
				try {
					System.out.println("Sleeping: " + Thread.currentThread().getName());

					Thread.sleep(5000);
				} catch (InterruptedException e1) {
					Thread.currentThread().interrupt();
					e1.printStackTrace();
				}
				lock.notifyAll(); // Notify Thread2 that data is ready
				try {
					lock.wait(); // Wait for Thread2 to consume
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
		}
	}

	static class Thread2 extends Thread {
		public void run() {
			synchronized (lock) {
				while (!dataReady) {
					System.out.println("Sleeping: " + Thread.currentThread().getName());

					try {
						Thread.sleep(2000);
						lock.wait(); // Wait for data to become ready
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					}
				}
				// Consume data
				System.out.println("Thread 2 received: " + sharedData);
				sharedData = null;
				dataReady = false;
				lock.notifyAll(); // Notify Thread 1
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread1 t1 = new Thread1();
		Thread2 t2 = new Thread2();
		t1.setName("t1");
		t2.setName("t2");
		t1.start();
		t2.start();
		t1.join();
		t2.join();
	}
}
