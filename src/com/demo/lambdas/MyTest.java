package com.demo.lambdas;

public class MyTest implements Numtest {

	@Override
	public boolean test(int n) {
		// TODO Auto-generated method stub
		return false;

	}

	// Method to be used as the method reference for the test method of the
	// functional interface Numtest
	public static boolean numTest(int n) {
		return n % 2 == 0;
	}

}
