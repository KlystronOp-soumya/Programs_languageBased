package com.problems;

//45=>45^2->2025->20+25
//check the sum of digits
public class KaprekarNumbers {

	public static boolean isKaprekarNumber(int n) {
		int sumn = 0, sumsq = 0;
		int temp = n;
		int sq = (int) Math.pow(temp, 2);

		while (temp != 0) {
			int rem = temp % 10;
			sumn += rem;
			temp /= 10;

		}

		while (sq != 0) {
			int rem = sq % 10;
			sumsq += rem;
			sq /= 10;
		}

		if ((sumn ^ sumsq) == 0)
			return true;
		else {
			return false;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isKaprekarNumber(10));
		System.out.println(isKaprekarNumber(45));
		System.out.println(isKaprekarNumber(99));
		System.out.println(isKaprekarNumber(50));
		System.out.println(isKaprekarNumber(33));
		System.out.println(isKaprekarNumber(13));
	}

}
