package com.problems;

class SharedResource {
	private int counter = 0;

	synchronized public void increment() {
		int temp = counter;
		// Simulate some processing time
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		counter = temp + 1;
	}

	public int getCounter() {
		return counter;
	}
}

public class RaceConditionDriver {

	public static void main(String[] args) {

		SharedResource resource = new SharedResource();

		// create thread1
		Runnable runnable1 = () -> {
			for (int i = 0; i < 5; i++) {
				resource.increment();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + " - Task1: " + resource.getCounter());
			}
		};

		// create thread1
		Runnable runnable2 = () -> {
			for (int i = 0; i < 5; i++) {
				resource.increment();
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + " - Task2: " + resource.getCounter());
			}
		};

		Thread task1 = new Thread(runnable1);
		task1.setName("Task1");
		Thread task2 = new Thread(runnable2);
		task2.setName("Task2");
		try {
			task1.start();
			task2.start();

			task1.join();
			task2.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
