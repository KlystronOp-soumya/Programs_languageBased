package com.demo.threading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Phaser;

class OrderProcessor implements Runnable {
	private final String orderId;
	private final Phaser fulfillmentPhaser;
	private static final Random random = new Random();

	public OrderProcessor(String orderId, Phaser phaser) {
		this.orderId = orderId;
		this.fulfillmentPhaser = phaser;
		fulfillmentPhaser.register(); // Each order processor registers itself
	}

	@Override
	public void run() {
		processOrder(1, "Order Received & Validated"); // simulates a task
		fulfillmentPhaser.arriveAndAwaitAdvance(); // once completed waits here

		processOrder(2, "Inventory Check & Packaging");
		fulfillmentPhaser.arriveAndAwaitAdvance();

		processOrder(3, "Shipping & Tracking");
		fulfillmentPhaser.arriveAndAwaitAdvance();

		processOrder(4, "Delivery Confirmation");
		fulfillmentPhaser.arriveAndDeregister(); // Order processing complete, deregister
	}

	private void processOrder(int phase, String stage) {
		System.out.println("Order " + orderId + " - Starting " + stage);
		try {
			Thread.sleep(random.nextInt(1500) + 500); // Simulate processing time
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		System.out.println("Order " + orderId + " - Completed " + stage);
	}
}

public class OrderFulfillmentSystem {
	public static void main(String[] args) throws InterruptedException {
		List<String> newOrders = List.of("ORD001", "ORD002", "ORD003", "ORD004", "ORD005");
		Phaser fulfillmentPhaser = new Phaser(1); // Register the main thread (coordinator)
		newOrders = newOrders.stream().sorted().toList();
		List<Thread> processors = new ArrayList<>();
		for (String orderId : newOrders) {
			OrderProcessor processor = new OrderProcessor(orderId, fulfillmentPhaser);
			Thread thread = new Thread(processor);
			processors.add(thread);
			thread.start();
		}

		// Simulate the fulfillment phases
		for (int phase = 1; phase <= 4; phase++) {
			System.out.println("\n--- Starting Fulfillment Phase " + phase + " ---");
			fulfillmentPhaser.arriveAndAwaitAdvance(); // Wait for all orders to complete this main phase
			System.out.println("--- Fulfillment Phase " + phase + " Completed ---");
		}

		fulfillmentPhaser.arriveAndDeregister(); // Coordinator finishes

		// Wait for all order processors to finish
		for (Thread thread : processors) {
			thread.join();
		}

		System.out.println("\nAll orders have been fully processed.");
	}
}