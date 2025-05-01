package com.demo.threading;

public class CustomCountDownLatch {
	private int count;

	public CustomCountDownLatch(int count) {
		if (count < 0) {
			throw new IllegalArgumentException("Count cannot be negative");
		}
		this.count = count;
	}

	// Method for threads to wait until the count reaches zero
	public synchronized void await() throws InterruptedException {
		while (count > 0) {
			wait();
		}
	}

	// Method to decrease the count and notify waiting threads if count reaches zero
	public synchronized void countDown() {
		if (count > 0) {
			count--;
			if (count == 0) {
				notifyAll();
			}
		}
	}

	// Optional: Get the current count
	public synchronized int getCount() {
		return count;
	}

}
