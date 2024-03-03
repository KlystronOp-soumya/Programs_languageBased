/**
 * 
 */
package com.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author Soumyadeep Paul
 * @since 2023
 *
 */
public class DateTimeDemo {

	/**
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {

		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

		// to check the last login date is within the 90 days period of current login
		// date
		// these are last logon date in string
		String lastLogOnDate = "25/09/2023"; // format: dd/M/YYYY
		Date ldt = format.parse(lastLogOnDate);
		System.out.println("Parsed date: " + ldt);
		// get the year month day from the date string
		int day = Integer.valueOf(lastLogOnDate.substring(0, 2));
		int month = Integer.valueOf(lastLogOnDate.substring(3, 5));
		int year = Integer.valueOf(lastLogOnDate.substring(6));
		// get the calendar object
		GregorianCalendar gCalendar = new GregorianCalendar(year, month - 1, day);// month starts from 0
		Date lastLogOnDt = gCalendar.getTime(); // take the date reference from the calendar

		// get the current date
		Calendar currCalendar = Calendar.getInstance();
		// set the instance to 90 days before
		currCalendar.add(Calendar.DAY_OF_MONTH, -90);

		Date prevNinghtyDayDate = currCalendar.getTime();

		// check if the last log in date is less than or equal to the date 90 days ago
		// of current date
		if (lastLogOnDt.compareTo(prevNinghtyDayDate) <= 0) {
			System.out.println("doSendMail()");
		}

		if (ldt.compareTo(prevNinghtyDayDate) <= 0) {
			System.out.println("doSendMail()");
		}

		checkSendMail();
	}

	private static void checkSendMail() throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		String lastLogOnDate = "25/09/2023";
		Date ldt = format.parse(lastLogOnDate);
		Calendar currCalendar = Calendar.getInstance();
		// set the instance to 90 days before
		currCalendar.add(Calendar.DAY_OF_MONTH, -90);

		Date prevNinghtyDayDate = currCalendar.getTime();
		if (ldt.compareTo(prevNinghtyDayDate) <= 0) {
			System.out.println("doSendMail()");
		}
	}

}
