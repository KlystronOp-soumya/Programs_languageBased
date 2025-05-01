package com.demo.threading;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

class OrderTask implements Runnable {
	private final String orderId;
	private final Phaser fulfillmentPhaser;
	private static final Random random = new Random();

	public OrderTask(String orderId, Phaser phaser) {
		this.orderId = orderId;
		this.fulfillmentPhaser = phaser;
		fulfillmentPhaser.register(); // Each order registers once
	}

	@Override
	public void run() {
		// Phase 1: Order Received & Validated AND Inventory Check & Packaging
		// (Concurrent)
		System.out.println("Order " + orderId + " - Starting Order Received & Validated");
		simulateWork(500, 1000);
		System.out.println("Order " + orderId + " - Completed Order Received & Validated");

		System.out.println("Order " + orderId + " - Starting Inventory Check & Packaging");
		simulateWork(800, 1200);
		System.out.println("Order " + orderId + " - Completed Inventory Check & Packaging");
		fulfillmentPhaser.arriveAndAwaitAdvance(); // Wait for all orders to complete Phase 1

		// Phase 2: Shipping & Tracking
		System.out.println("Order " + orderId + " - Starting Shipping & Tracking");
		simulateWork(300, 800);
		System.out.println("Order " + orderId + " - Completed Shipping & Tracking");
		fulfillmentPhaser.arriveAndAwaitAdvance(); // Wait for all orders to complete Phase 2

		// Phase 3: Delivery Confirmation
		System.out.println("Order " + orderId + " - Starting Delivery Confirmation");
		simulateWork(1000, 1500);
		System.out.println("Order " + orderId + " - Completed Delivery Confirmation");
		fulfillmentPhaser.arriveAndDeregister(); // Order fully processed
	}

	private void simulateWork(int minMillis, int maxMillis) {
		try {
			Thread.sleep(random.nextInt(maxMillis - minMillis + 1) + minMillis);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}

public class CorrectedConcurrentOrderFulfillmentSystem {
	public static void main(String[] args) throws InterruptedException {
		List<String> newOrders = List.of("ORD001", "ORD002", "ORD003");
		Phaser fulfillmentPhaser = new Phaser(1); // Register the main thread

		ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

		for (String orderId : newOrders) {
			executor.submit(new OrderTask(orderId, fulfillmentPhaser));
		}

		// Phase 1: Order Received & Validated AND Inventory Check & Packaging
		// (Concurrent within each OrderTask)
		System.out.println("\n--- Starting Fulfillment Phase 1: Order Reception & Inventory Check ---");
		fulfillmentPhaser.arriveAndAwaitAdvance(); // Wait for all OrderTasks to complete Phase 1

		// Phase 2: Shipping & Tracking
		System.out.println("\n--- Starting Fulfillment Phase 2: Shipping & Tracking ---");
		fulfillmentPhaser.arriveAndAwaitAdvance(); // Wait for all OrderTasks to complete Phase 2

		// Phase 3: Delivery Confirmation
		System.out.println("\n--- Starting Fulfillment Phase 3: Delivery Confirmation ---");
		fulfillmentPhaser.arriveAndAwaitAdvance(); // Wait for all OrderTasks to complete Phase 3

		fulfillmentPhaser.arriveAndDeregister(); // Main thread finishes

		executor.shutdown();
		executor.awaitTermination(5, TimeUnit.SECONDS);

		System.out.println("\nAll orders have been fully processed through all phases.");
	}
}