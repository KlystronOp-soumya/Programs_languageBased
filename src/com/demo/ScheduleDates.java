package com.demo;

import java.time.LocalDate;
import java.util.function.Function;

/*
 * Demonstrates the Java 8 Lambda with Enums 
 * 
 * */
public enum ScheduleDates {
	DAILY(date -> date.plusDays(1)), WEEKLY(date -> date.plusWeeks(1)), MONTHLY(date -> date.plusMonths(1)),
	QUARTERLY(date -> date.plusMonths(3)), BIANNUALLY(date -> date.plusMonths(6)), ANNUALLY(date -> date.plusYears(1)),;

	private final Function<LocalDate, LocalDate> nextDateFunction; // or UnaryOperator<LocalDate>

	ScheduleDates(Function<LocalDate, LocalDate> nextDateFunction) {
		this.nextDateFunction = nextDateFunction;
	}

	public LocalDate calculateNextDate(LocalDate dateFrom) {
		return nextDateFunction.apply(dateFrom);
	}

	public static void main(String[] args) {
		LocalDate today = LocalDate.of(2019, 9, 18); // 2019 Sep 18
		ScheduleDates.DAILY.calculateNextDate(today); // 2019-09-19
		ScheduleDates.MONTHLY.calculateNextDate(today); // 2019-10-19
	}
}
