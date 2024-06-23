package com.problems;

public class MathUtil {

	public static void main(String[] args) {

		System.out.println(checkValidPowerOfBase(2, 8));
		System.out.println(checkValidPowerOfBase(2, 3));
		System.out.println(checkValidPowerOfBase(3, 27));
		System.out.println(checkPrime(4));
		System.out.println(checkPrime(5));

	}

	private static boolean checkPrime(int num) {

		boolean flag = true;

		for (int i = 2; i <= num / 2; i++) {
			if (num % i == 0) {
				flag = false;
				break;
			}
		}

		return flag;
	}

	// using recursion
	private static boolean checkValidPowerOfBase(int base, int result) {
		int rem = result % base;
		boolean flag = false;

		if (rem == 1) {
			return flag;
		}
		if (base > result) {
			return flag;
		}
		while (rem != 0) {
			result /= base;
			return checkValidPowerOfBase(base, result / base);
		}
		return true;

	}

}
