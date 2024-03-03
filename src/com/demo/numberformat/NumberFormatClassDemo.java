package com.demo.numberformat;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormatClassDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double n = 1240.35;
		long val1 = 23_500_390_800_380L;
		double val4 = 4.5678934;
		double val5 = 2.3;

		NumberFormat nf = NumberFormat.getInstance(new Locale("en", "US"));
		String val = nf.format(n);

		System.out.println(val);

		NumberFormat nf2 = NumberFormat.getInstance(new Locale("sk", "SK"));
		String val2 = nf2.format(n);

		System.out.println(val2);

		NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK"));
		String val3 = nf3.format(n);

		System.out.println(val3);

		// grouping

		nf.setGroupingUsed(true);
		System.out.println("After Gotuping: " + nf.format(val1));
		// set Fractions
		nf.setMinimumFractionDigits(2);
		nf.setMaximumFractionDigits(4);

		System.out.println(nf.format(val4));
		System.out.println(nf.format(val5));

		// Rounding
		double nums[] = { 2.32, 2.55, 3.19, 4.88, 5.54, 3.22, 8.78 };

		NumberFormat nf4 = NumberFormat.getInstance(Locale.ENGLISH);
		nf.setMaximumFractionDigits(1);
		nf.setRoundingMode(RoundingMode.UP);

		for (double num : nums) {

			String number = nf4.format(num);
			System.out.printf("%s ", number);
		}

		System.out.println();

		nf.setRoundingMode(RoundingMode.DOWN);

		for (double num : nums) {

			String number = nf.format(num);
			System.out.printf("%s ", number);
		}

		System.out.println();

	}

}
