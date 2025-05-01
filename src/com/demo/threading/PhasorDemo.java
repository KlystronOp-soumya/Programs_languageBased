package com.demo.threading;

import java.util.concurrent.Phaser;

class Worker implements Runnable {
	private final String name;
	private final Phaser phaser;

	public Worker(String name, Phaser phaser) {
		this.name = name;
		this.phaser = phaser;
		phaser.register(); // Register this worker with the phaser
	}

	@Override
	public void run() {
		for (int phase = 1; phase <= 3; phase++) {
			System.out.println(name + " is starting phase " + phase);
			doWork(phase);
			phaser.arriveAndAwaitAdvance(); // Wait for all registered threads to reach this phase

			System.out.println(name + " has completed phase " + phase);
		}
		phaser.arriveAndDeregister(); // Deregister when done with all phases
	}

	private void doWork(int phase) {
		try {
			System.out.println("Doing something.... + " + this.name);
			Thread.sleep((long) (Math.random() * 1000)); // Simulate work
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}

public class PhasorDemo {

	public static void main(String[] args) throws InterruptedException {
		Phaser phaser = new Phaser(1); // Initial phase count (can be 0)

		Thread worker1 = new Thread(new Worker("Worker 1", phaser));
		Thread worker2 = new Thread(new Worker("Worker 2", phaser));
		Thread worker3 = new Thread(new Worker("Worker 3", phaser));

		worker1.start();
		worker2.start();
		worker3.start();

		// Main thread also participates in the phases
		for (int phase = 1; phase <= 3; phase++) {
			System.out.println("Main thread starting phase " + phase);
			phaser.arriveAndAwaitAdvance();
			System.out.println("Main thread completed phase " + phase);
		}
		worker1.join();
		worker2.join();
		worker3.join();
		phaser.arriveAndDeregister(); // Deregister the main thread

		System.out.println("All workers and main thread have completed all phases.");
	}
}