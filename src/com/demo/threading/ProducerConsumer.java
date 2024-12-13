package com.demo.threading;

import java.util.LinkedList;
import java.util.Queue;

class SharedResource {
	private final Queue<Integer> queue = new LinkedList<>();
	private final int capacity;

	public SharedResource(int capacity) {
		this.capacity = capacity;
	}

	public void produce(int value) throws InterruptedException {
		synchronized (this) {
			while (queue.size() == capacity) {

				wait(); // asks the producer to wait until the consumer is finished consuming
			}
			queue.add(value);
			System.out.println("Produced: " + value);
			notify(); // it notifies the producer
		}
	}

	public void consume() throws InterruptedException {
		synchronized (this) {
			while (queue.isEmpty()) {

				wait();
			}
			int value = queue.remove();
			System.out.println("Consumed: " + value);
			notify();
		}
	}
}

class Producer extends Thread {
	private final SharedResource sharedResource;

	public Producer(SharedResource sharedResource) {
		this.sharedResource = sharedResource;
	}

	@Override
	public void run() {
		int value = 0;
		while (true) {
			try {
				sharedResource.produce(value++);
				Thread.sleep(500); // Simulate time taken to produce
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Consumer extends Thread {
	private final SharedResource sharedResource;

	public Consumer(SharedResource sharedResource) {
		this.sharedResource = sharedResource;
	}

	@Override
	public void run() {
		while (true) {
			try {
				sharedResource.consume();
				Thread.sleep(1500); // Simulate time taken to consume
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class ProducerConsumer {
	public static void main(String[] args) {
		SharedResource sharedResource = new SharedResource(5);
		Producer producer = new Producer(sharedResource);
		Consumer consumer = new Consumer(sharedResource);

		producer.setName("Producer Thread");
		consumer.setName("Consumer Thread");
		producer.start();
		consumer.start();
	}
}
