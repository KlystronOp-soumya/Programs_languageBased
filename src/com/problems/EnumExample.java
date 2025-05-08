package com.problems;

public class EnumExample {

	enum Departments {
		// these are objects
		ACCOUNTS("act") {

			@Override
			public void showVal() {
				System.out.println(this.name());
			}

		},
		FINANCE {
			@Override
			public void showVal() {
				// TODO Auto-generated method stub

			}
		},
		STOCKS {
			@Override
			public void showVal() {
				// TODO Auto-generated method stub

			}
		},
		TRADES {
			@Override
			public void showVal() {
				// TODO Auto-generated method stub

			}
		},
		NETWORKING {
			@Override
			public void showVal() {
				// TODO Auto-generated method stub

			}
		},
		MARKETING {
			@Override
			public void showVal() {
				// TODO Auto-generated method stub

			}
		},
		ITINFRA {
			@Override
			public void showVal() {
				// TODO Auto-generated method stub

			}
		},
		ITAPP {
			@Override
			public void showVal() {
				// TODO Auto-generated method stub

			}
		},
		ITNETWORKING {
			@Override
			public void showVal() {
				// TODO Auto-generated method stub

			}
		};

		public String account_code;

		private Departments() {

		}

		Departments(final String code) {
			this.account_code = code;
		}

		public abstract void showVal();

	}

	public static void main(String[] args) {

		Departments d1 = Departments.ACCOUNTS, d2 = Departments.FINANCE, d3 = Departments.valueOf("ITAPP");

		System.out.println("Department name: " + d1.ordinal());
		System.out.println("Value: " + d2.valueOf("ACCOUNTS"));
		System.out.println("value: " + d2.ordinal());

		Departments[] arr = Departments.values();
		System.out.println(arr.length);
		System.out.println(arr[1]);
		System.out.println(arr[1].ordinal());
		System.out.println(d3);
		arr[0].showVal();

	}
}
