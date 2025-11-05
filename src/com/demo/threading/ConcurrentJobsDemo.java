package com.demo.threading;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ConcurrentJobsDemo {

	public static void main(String[] args) throws Exception {

		ConcurrentJobsDemo concurrentJobsDemo = new ConcurrentJobsDemo();
		Job job1 = concurrentJobsDemo.new Job("Job1",
				Arrays.asList(() -> sleep(1000), () -> sleep(800), () -> sleep(1200)));

		Job job2 = concurrentJobsDemo.new Job("Job2",
				Arrays.asList(() -> sleep(700), () -> sleep(1000), () -> sleep(500)));

		Job job3 = concurrentJobsDemo.new Job("Job3",
				Arrays.asList(() -> sleep(500), () -> sleep(700), () -> waitForUserInput()));

		List<Callable<Void>> jobs = Arrays.asList(job1, job2, job3);

		System.out.println("Submitting jobs...");
		ExecutorService executor = Executors.newFixedThreadPool(3);
		List<Future<Void>> futures = executor.invokeAll(jobs);

		for (Future<Void> future : futures) {
			future.get();// ensures completion
		}
		System.out.println("Jobs are done");
		executor.shutdown();

		if (executor.isShutdown()) {
			System.out.println("Resource freed");
		}
	}

	private static void sleep(long ms) {
		try {
			Thread.sleep(ms);
		} catch (Exception e) {
			Thread.currentThread().interrupt();
		}
	}

	private static void waitForUserInput() {
		Scanner scanner = new Scanner(System.in);
		String input = "";

		final Object monitor = new Object(); // used for synchronization
		Thread timerThread = startElapsedTimer(monitor);

		while (true) {
			System.out.print("Job3 - Step 3: Please type 'yes' to finish: ");
			input = scanner.nextLine().trim().toLowerCase();

			if ("yes".equals(input)) {
				synchronized (monitor) {
					monitor.notify(); // signal timer thread to stop
				}
				System.out.println("Input validated: proceeding to complete Job3...");
				break;
			} else {
				System.out.println("Invalid input. Try again.");
			}
		}
		try {
			timerThread.join(100); // wait a bit for graceful termination

		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		} finally {
			scanner.close();
		}

	}

	private static Thread startElapsedTimer(Object monitor) {
		Thread timerThread = new Thread(() -> {
			long startTime = System.currentTimeMillis();

			while (true) {
				synchronized (monitor) {
					try {
						// Wait for 1 second, unless notified earlier
						monitor.wait(1000); // lock on the object not the thread
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
						return;
					}

					// If notified, break out (stop timer)
					if (Thread.interrupted()) {
						System.out.println("Object lock was interrupted!");
						break;
					}

					long elapsed = System.currentTimeMillis() - startTime;
					long seconds = elapsed / 1000;
					long hours = seconds / 3600;
					long minutes = (seconds % 3600) / 60;
					long secs = seconds % 60;
					System.out.printf("⏱ waited: %dh %dm %ds%n", hours, minutes, secs);
				}

				// check if notified (avoid one extra print)
				synchronized (monitor) {
					if (Thread.currentThread().isInterrupted()) {
						System.out.println("Timer was interrupted!");
						break;
					}

				}
			}

			long total = System.currentTimeMillis() - startTime;
			long totalSec = total / 1000;
			long totalMin = (totalSec % 3600) / 60;
			long totalHr = totalSec / 3600;
			System.out.printf("🕒 Total waiting time: %dh %dm %ds%n", totalHr, totalMin, totalSec % 60);
		});

		timerThread.setDaemon(true);
		timerThread.start();
		return timerThread;
	}

	private class Job implements Callable<Void> {

		private String name;
		private List<Runnable> steps;

		public Job(final String name, List<Runnable> steps) {
			this.name = name;
			this.steps = steps;
		}

		@Override
		public Void call() throws Exception {

			System.out.println("Starting : " + this.name);
			for (int i = 0; i < steps.size(); i++) {
				System.out.println(" " + this.name + "-step " + (i + 1));
				Thread.currentThread().setName(this.name.concat("_%s-%d".formatted("step", (i + 1))));
				steps.get(i).run();

			}
			System.out.println("Finished->" + this.name + "[%s]".formatted(Thread.currentThread().getName()));
			return null;
		}

	}

}
