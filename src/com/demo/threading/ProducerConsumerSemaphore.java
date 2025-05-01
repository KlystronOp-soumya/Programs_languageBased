package com.demo.threading;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerSemaphore {

	// Inner class: CountingSemaphore (Implemented from scratch)
	static class CountingSemaphore {
		private int permits;

		public CountingSemaphore(int initialPermits) {
			if (initialPermits < 0) {
				throw new IllegalArgumentException("Initial permits cannot be negative");
			}
			this.permits = initialPermits;
		}

		public synchronized void acquire() throws InterruptedException {
			while (permits == 0) {
				wait();
			}
			permits--;
		}

		public synchronized void acquire(int requiredPermits) throws InterruptedException {
			if (requiredPermits < 0) {
				throw new IllegalArgumentException("Required permits cannot be negative");
			}
			while (permits < requiredPermits) {
				wait();
			}
			permits -= requiredPermits;
		}

		public synchronized void release() {
			permits++;
			notify();
		}

		public synchronized void release(int releasedPermits) {
			if (releasedPermits < 0) {
				throw new IllegalArgumentException("Released permits cannot be negative");
			}
			permits += releasedPermits;
			notifyAll();
		}

		public synchronized int availablePermits() {
			return permits;
		}
	}

	// Shared buffer (queue)
	private static final Queue<Integer> buffer = new LinkedList<>();
	// Maximum buffer size
	private static final int BUFFER_SIZE = 5;

	// Semaphores for synchronization
	private static final CountingSemaphore empty = new CountingSemaphore(BUFFER_SIZE); // Initially, buffer is empty
	private static final CountingSemaphore full = new CountingSemaphore(0); // Initially, buffer is full
	private static final CountingSemaphore mutex = new CountingSemaphore(1); // For mutual exclusion to access the
																				// buffer

	// Producer task
	static class Producer extends Thread {
		private final int id;
		private static int itemNumber = 0;

		public Producer(int id) {
			this.id = id;
		}

		@Override
		public void run() {
			try {
				while (true) {
					int item = itemNumber++;
					empty.acquire(); // Wait if buffer is full
					mutex.acquire(); // Acquire lock for buffer access
					buffer.offer(item);
					System.out.println("Producer " + id + " produced item " + item + ". Buffer size: " + buffer.size());
					mutex.release(); // Release lock
					full.release(); // Signal that buffer is not empty
					Thread.sleep(100); // Simulate production time
				}
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				System.out.println("Producer " + id + " interrupted.");
			}
		}
	}

	// Consumer task
	static class Consumer extends Thread {
		private final int id;

		public Consumer(int id) {
			this.id = id;
		}

		@Override
		public void run() {
			try {
				while (true) {
					full.acquire(); // Wait if buffer is empty
					mutex.acquire(); // Acquire lock for buffer access
					Integer item = buffer.poll();
					System.out.println("Consumer " + id + " consumed item " + item + ". Buffer size: " + buffer.size());
					mutex.release(); // Release lock
					empty.release(); // Signal that buffer is not full
					Thread.sleep(300); // Simulate consumption time
				}
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				System.out.println("Consumer " + id + " interrupted.");
			}
		}
	}

	public static void main(String[] args) {
		// Number of producers and consumers
		final int NUM_PRODUCERS = 2;
		final int NUM_CONSUMERS = 3;

		// Create producer and consumer threads
		Producer[] producers = new Producer[NUM_PRODUCERS];
		Consumer[] consumers = new Consumer[NUM_CONSUMERS];

		for (int i = 0; i < NUM_PRODUCERS; i++) {
			producers[i] = new Producer(i + 1);
			producers[i].start();
		}
		for (int i = 0; i < NUM_CONSUMERS; i++) {
			consumers[i] = new Consumer(i + 1);
			consumers[i].start();
		}

		// Let the program run for a while
		try {
			Thread.sleep(10000); // Let the program run for 10 seconds
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			System.out.println("Main thread interrupted.");
		}

		// Interrupt all threads
		for (Producer producer : producers) {
			producer.interrupt();
		}
		for (Consumer consumer : consumers) {
			consumer.interrupt();
		}

		// Wait for threads to finish (optional, but good practice)
		for (Producer producer : producers) {
			try {
				producer.join();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				System.out.println("Producer join interrupted.");
			}
		}
		for (Consumer consumer : consumers) {
			try {
				consumer.join();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				System.out.println("Consumer join interrupted.");
			}
		}

		System.out.println("Program finished.");
	}
}
