package com.demo.threading;

public class CustomCyclicBarrier {
	private final int initialParties; // Number of threads to wait
	private int partiesAwaiting; // Number of threads currently waiting
	private Runnable barrierAction; // Optional action to run when all threads reach the barrier

	public CustomCyclicBarrier(int parties, Runnable barrierAction) {
		if (parties <= 0) {
			throw new IllegalArgumentException("Number of parties must be greater than zero");
		}
		this.initialParties = parties;
		this.partiesAwaiting = parties;
		this.barrierAction = barrierAction;
	}

	public CustomCyclicBarrier(int parties) {
		this(parties, null);
	}

	// Method to simulate threads arriving at the barrier
	public synchronized void await() throws InterruptedException {
		partiesAwaiting--; // Thread reaches the barrier
		if (partiesAwaiting > 0) {
			wait(); // Wait until all threads reach the barrier
		} else {
			// All threads have arrived at the barrier
			if (barrierAction != null) {
				barrierAction.run(); // Execute the optional action
			}
			partiesAwaiting = initialParties; // Reset for the next cycle
			notifyAll(); // Release all threads
		}
	}

	// Optional: Get the number of parties still waiting
	public synchronized int getPartiesAwaiting() {
		return partiesAwaiting;
	}
}
