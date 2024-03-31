package com.demo;

import java.util.StringTokenizer;

public class StringManipulation {

	public static void main(String[] args) {

		String str = "a,b,c,d";
		StringTokenizer stringTokenizer = new StringTokenizer(str, ",");

		while (stringTokenizer.hasMoreTokens()) {
			System.out.println(stringTokenizer.nextElement());
		}
	}

}
