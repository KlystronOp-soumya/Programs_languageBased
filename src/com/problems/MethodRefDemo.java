package com.problems;

@FunctionalInterface
interface NumUtil {
	boolean apply(int n);
}

class NumUtilImpl implements NumUtil {

	@Override
	public boolean apply(int n) {

		return n % 2 == 0;
	}

	public void foo(NumUtil numUtil, int n) {
		numUtil.apply(4);
	}

}

class NumTest {

	public boolean isLeapYear(int n) {
		return n % 4 == 0;
	}
}

public class MethodRefDemo {

	public static void main(String[] args) {

		NumUtil numUtil = (n) -> n % 2 == 0;

		NumUtilImpl numUtilImpl = new NumUtilImpl();

		// with out method reference
		numUtilImpl.foo(numUtil, 0);

		// Method
		NumTest objNumTest = new NumTest();
		numUtilImpl.foo(objNumTest::isLeapYear, 2020);

		System.out.println("The number is even? " + numUtil.apply(4));

	}

}
