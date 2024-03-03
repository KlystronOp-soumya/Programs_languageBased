package com.demo.locales;

import java.util.Locale;

public class LocaleDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Get the array of the Locales

		Locale lcLocale = Locale.getDefault();
		// shows en_US
		System.out.println("Default Locale: " + lcLocale);
		// get all the locales
		Locale[] availableLocales = Locale.getAvailableLocales();

		for (Locale l : availableLocales) {
			System.out.println(l + " country: " + l.getCountry() + " Language:" + l.getLanguage());
		}
	}

}
