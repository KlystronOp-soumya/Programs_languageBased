package com.demo.threading;

import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableJobDemo {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(3);

		CompletableFuture<Void> job1 = CompletableFuture.runAsync(() -> runJob("Job1"), executor);
		CompletableFuture<Void> job2 = CompletableFuture.runAsync(() -> runJob("Job2"), executor);
		CompletableFuture<Void> job3 = CompletableFuture.runAsync(() -> runJobWithInput("Job3"), executor);

		// Wait for all jobs to complete
		CompletableFuture<Void> allJobs = CompletableFuture.allOf(job1, job2, job3);

		allJobs.thenRun(() -> System.out.println("✅ All jobs finished. Program exiting...")).join();

		executor.shutdown();
	}

	private static void runJob(String name) {
		System.out.println("Starting " + name);
		for (int i = 1; i <= 3; i++) {
			System.out.println("  " + name + " - Step " + i);
			sleep(1000);
		}
		System.out.println(name + " finished!");
	}

	private static void runJobWithInput(String name) {
		System.out.println("Starting " + name);
		for (int i = 1; i <= 2; i++) {
			System.out.println("  " + name + " - Step " + i);
			sleep(1000);
		}

		waitForUserInput();

		System.out.println(name + " finished!");
	}

	private static void sleep(long ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	private static void waitForUserInput() {
		Scanner scanner = new Scanner(System.in);
		String input;
		do {
			System.out.print("Job3 - Step 3: Type 'yes' to finish: ");
			input = scanner.nextLine().trim().toLowerCase();
		} while (!"yes".equals(input));
		System.out.println("✅ Input validated: proceeding...");
	}
}
