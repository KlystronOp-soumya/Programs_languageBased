package com.demo;

import java.text.DateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

class TimeDateManageMent {
	//
}

public class DateTimeZoneDemo {

	@SuppressWarnings({ "deprecation", "static-access" })
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date dt = new Date();
		System.out.println("Today is: " + dt);
		// convert to date
		Date dt2 = new Date(1997, 7, 3);// Jan in 0
		System.out.println("My Birthdate:" + dt2);
		// creating from instant
		Date d = new Date();
		Instant i = Instant.now();
		System.out.println("date  : " + d.from(i));

		// Time and Date using Calender
		// create a calendar class instance
		Calendar calendar = Calendar.getInstance();
		System.out.println("my timezone: " + calendar.getTimeZone());

		System.out.println("Showing current time using calendar");
		System.out.println("HH:" + calendar.get(calendar.HOUR));
		System.out.println("MM:" + calendar.get(calendar.MINUTE));
		System.out.println("SS:" + calendar.get(calendar.SECOND));

		System.out.println("Showing full time:" + calendar.getTime());
		System.out.println("Calendar type:" + calendar.getCalendarType());

		System.out.println("YY:" + calendar.get(calendar.YEAR));
		System.out.println("MM:" + calendar.get(calendar.MONTH));

		// set timezone
		System.out.println("Setting timezone...");
		System.out.println("Timezone: " + calendar.getTimeZone().getDisplayName());
		// setting
		calendar.setTimeZone(TimeZone.getTimeZone("GMT"));
		System.out.println("Updated Timezone: " + calendar.getTimeZone().getDisplayName());

		// DateFormate
		System.out.println("Formatting the date");

		Date currentDate = new Date();
		System.out.println("Current Date: " + currentDate);

		String dateToStr = DateFormat.getInstance().format(currentDate);
		System.out.println("Date Format using getInstance(): " + dateToStr);

		dateToStr = DateFormat.getDateInstance().format(currentDate);
		System.out.println("Date Format using getDateInstance(): " + dateToStr);

		dateToStr = DateFormat.getTimeInstance().format(currentDate);
		System.out.println("Date Format using getTimeInstance(): " + dateToStr);

		dateToStr = DateFormat.getDateTimeInstance().format(currentDate);
		System.out.println("Date Format using getDateTimeInstance(): " + dateToStr);

		dateToStr = DateFormat.getTimeInstance(DateFormat.SHORT).format(currentDate);
		System.out.println("Date Format using getTimeInstance(DateFormat.SHORT): " + dateToStr);

		dateToStr = DateFormat.getTimeInstance(DateFormat.MEDIUM).format(currentDate);
		System.out.println("Date Format using getTimeInstance(DateFormat.MEDIUM): " + dateToStr);

		dateToStr = DateFormat.getTimeInstance(DateFormat.LONG).format(currentDate);
		System.out.println("Date Format using getTimeInstance(DateFormat.LONG): " + dateToStr);

		dateToStr = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.SHORT).format(currentDate);
		System.out.println("Date Format using getDateTimeInstance(DateFormat.LONG,Da)" + dateToStr);
	}

}
