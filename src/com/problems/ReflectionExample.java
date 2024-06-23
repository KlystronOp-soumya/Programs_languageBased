package com.problems;

import java.lang.reflect.Method;

public class ReflectionExample {
	public int test(int i) {
		return i + 1;
	}

	public static void main(String args[]) throws Exception {
		Method testMethod = ReflectionExample.class.getMethod("test", int.class);
		int result = (Integer) testMethod.invoke(new ReflectionExample(), 100);
		System.out.println(result); // Output: 101
	}
}
