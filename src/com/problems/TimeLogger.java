package com.problems;

import java.time.Duration;
import java.time.Instant;

public class TimeLogger {

	public static void main(String[] args) {
		TimeLogger logger = new TimeLogger();
		logger.methodToTime();
	}

	public void methodToTime() {
		Instant start = Instant.now();

		// Method logic here
		try {
			for (int i = 0; i < 100; i++) {
				Thread.sleep(5000); // Simulate some work with a sleep
			}

		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}

		Instant end = Instant.now();
		Duration duration = Duration.between(start, end);

		// Extract hours, minutes, and seconds
		long hours = duration.toHours();
		long minutes = duration.toMinutesPart();
		long seconds = duration.toSecondsPart();

		System.out.printf("Execution time: %02d:%02d:%02d\n", hours, minutes, seconds);
	}
}
