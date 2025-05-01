package com.demo;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class LocaleDateTimeDemo {

	public static void main(String[] args) {
		ZonedDateTime zonedDateTime = ZonedDateTime.now();

		System.out.println(zonedDateTime.getZone());
		LocalDateTime dateTime = LocalDateTime.now(zonedDateTime.getZone());
		System.out.println(dateTime);
		DateTimeFormatter formatterD = DateTimeFormatter.ofPattern("YYYY-M-d", Locale.US);
		DateTimeFormatter formatterT = DateTimeFormatter.ofPattern("H:m:ss", Locale.US);
		System.out.println(dateTime.format(formatterD));
		System.out.println(dateTime.format(formatterT));

	}

}
