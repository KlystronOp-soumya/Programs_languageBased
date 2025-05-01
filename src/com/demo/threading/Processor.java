package com.demo.threading;

import java.util.Scanner;

public class Processor {

	public void producer() throws InterruptedException {

		Thread.currentThread().setName("Producer thread");
		synchronized (this) {
			Thread.sleep(2000);
			System.out.println("Thread " + Thread.currentThread().toString() + " was put to sleep before wait");
			wait();
		}
		System.out.println("Producer was resumed");

	}

	public void consumer() throws InterruptedException {

		final Scanner sc = new Scanner(System.in);
		Thread.currentThread().setName("Consumer Thread");
		Thread.sleep(3000);
		synchronized (this) {
			System.out.println("Waiting for return key...");
			sc.nextLine();
			System.out.println("Return key was pressed!");
			notify();
			Thread.sleep(5000);
			System.out.println("Thread state: " + Thread.currentThread().getState().name());
		}

	}

	public static void main(String[] args) {
		Processor prod = new Processor();
		Processor cons = new Processor();
		try {
			Runnable prodRun = () -> {
				try {

					prod.producer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			};

			Runnable consRun = () -> {
				try {
					prod.consumer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			};

			Thread t1 = new Thread(prodRun);
			Thread t2 = new Thread(consRun);

			t1.start();
			t2.start();
			// If I put here the main thread will be interrrupted
			// Thread.currentThread().interrupt();
			t1.join();
			t2.join();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
