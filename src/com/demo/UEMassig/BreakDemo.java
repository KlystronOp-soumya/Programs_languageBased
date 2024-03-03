package com.demo.UEMassig;

public class BreakDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean f = true;

		f_1: {
			f_2: {
				f_3: {
					System.out.println("Hi there!");
					if (f) {
						break f_2;
					}

					System.out.println("Hello");
				} // f_3
				System.out.println("Debjani");
			} // f_2
			System.out.println("Soumik");
		} // f_1

	}

}
