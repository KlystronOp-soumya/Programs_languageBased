package com.demo;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ElapsedMonths {

	public static void getElapsedMonth() {
		GregorianCalendar start = new GregorianCalendar(2023, Calendar.JANUARY, 15);
		GregorianCalendar end = new GregorianCalendar(2025, Calendar.JULY, 14);

		int yearsDiff = end.get(Calendar.YEAR) - start.get(Calendar.YEAR);
		int monthsDiff = end.get(Calendar.MONTH) - start.get(Calendar.MONTH);

		int totalMonths = yearsDiff * 12 + monthsDiff;

		System.out.println("Elapsed months: " + totalMonths);

		LocalDate startM = LocalDate.of(2023, 1, 15);
		LocalDate endM = LocalDate.of(2025, 7, 14);

		Period period = Period.between(startM, endM);
		int totalMonthsM = period.getYears() * 12 + period.getMonths();

		System.out.println("Elapsed months: " + totalMonthsM);

	}

	public static void main(String[] args) {
		getElapsedMonth();
	}

}
