package com.problems;

public class AnnotationsExample {

	enum Departments {
		// these are objects
		ACCOUNTS("act"), FINANCE, STOCKS, TRADES, NETWORKING, MARKETING, ITINFRA, ITAPP, ITNETWORKING;

		public String account_code;

		private Departments() {

		}

		Departments(final String code) {
			this.account_code = code;
		}
	}

	public static void main(String[] args) {

		Departments d1 = Departments.ACCOUNTS, d2 = Departments.FINANCE;

		System.out.println("Department name: " + d1.ordinal());
		System.out.println("Value: " + d2.valueOf("ACCOUNTS"));
		System.out.println("value: " + d2.ordinal());
	}
}
