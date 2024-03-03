package com.demo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeAPIDemo {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDateTime dt1 = LocalDateTime.now();
		System.out.println("Before Formatting");
		System.out.println(dt1);

		// create a formatter
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-YYYY HH:mm:ss");
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd-MM-YYYY");
		DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("HH-mm-ss");
		System.out.println("After formatting:");
		String formattedString = dt1.format(formatter);
		String formattedString2 = dt1.format(formatter2);
		String formattedString3 = dt1.format(formatter3);

		System.out.println(formattedString);
		System.out.println(formattedString2);
		System.out.println(formattedString3);

		// LocalDate

		LocalDate date = LocalDate.now();
		System.out.println("Today: " + date);

		LocalDate yesterdayDate = date.minusDays(1);
		System.out.println("Yesterday: " + yesterdayDate);

		System.out.println("Comapred: " + date.compareTo(yesterdayDate));// provides the difference can be used as the
																			// substitute for the before() or after()
		// LocalTime
		LocalTime nowLocalTime = LocalTime.now();// can be given the zone id
		System.out.println("Time now: " + nowLocalTime);

		LocalTime twoHoursBackLocalTime = nowLocalTime.minusHours(3);// advance plusHours()
		System.out.println("Time 2 hours back: " + twoHoursBackLocalTime);

		System.out.println("Comapring: " + nowLocalTime.compareTo(twoHoursBackLocalTime));

		// Zones
		ZonedDateTime zonedDateTime = ZonedDateTime.now();
		System.out.println("Zone: " + zonedDateTime);
		System.out.println("Current zone: " + zonedDateTime.getZone());

		ZonedDateTime zone = ZonedDateTime.parse("2016-10-05T08:20:10+05:30[Asia/Kolkata]");
		System.out.println(zone);

		LocalDateTime ldt = LocalDateTime.of(2017, Month.JANUARY, 19, 15, 26);
		ZoneId india = ZoneId.of("Asia/Kolkata");
		ZonedDateTime zone1 = ZonedDateTime.of(ldt, india);
		System.out.println("In India Central Time Zone: " + zone1);

		ZoneId tokyo = ZoneId.of("Asia/Tokyo");
		ZonedDateTime zone2 = zone1.withZoneSameInstant(tokyo);
		System.out.println("In Tokyo Central Time Zone:" + zone2);

		LocalDateTime japanDateTime = LocalDateTime.now(ZoneId.of("Asia/Tokyo"));
		System.out.println("Time now at Japan: " + japanDateTime);

		// getALl the zoneIds

		/*
		 * String[] idString = TimeZone.getAvailableIDs(); for (String id : idString)
		 * System.out.println(id);
		 */
	}

}
