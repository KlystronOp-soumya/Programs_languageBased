package com.demo.locales;

import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int val = 23_500;

		NumberFormat cf1 = NumberFormat.getCurrencyInstance(new Locale("en", "US"));
		System.out.println(cf1.format(val));

		NumberFormat cf2 = NumberFormat.getCurrencyInstance(new Locale("sk", "SK"));
		System.out.println(cf2.format(val));

		NumberFormat cf3 = NumberFormat.getCurrencyInstance(new Locale("zh", "CN"));
		System.out.println(cf3.format(val));
	}

}
