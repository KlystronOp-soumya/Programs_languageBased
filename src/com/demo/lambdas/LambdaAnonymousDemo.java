package com.demo.lambdas;

public class LambdaAnonymousDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Demo 1
		// Conventional approach
		// create object and call the method

		Numtest numtest = new MyTest();
		assert !numtest.test(2) : "Not Valid";

		// Demo 2
		// Anonymous class method

		Numtest numtestAnonym = new Numtest() {

			@Override
			public boolean test(int n) {
				// TODO Auto-generated method stub
				return true;
			}
		};

		assert numtestAnonym.test(1) : "not valid";

		// Demo 3
		// Lambda approach

		Numtest numtestLambda = (n) -> { // target type assigned
			return true;
		};

		// Demo 4
		// The above method is the implementation for the method test
		// When the method call is invoked internally an object is created and method is
		// called
		assert numtestLambda.test(1) : "Not Valid";

		// Demo 5
		// Method reference

		funcTest(MyTest::numTest, 0);

	}

	static void funcTest(Numtest numtestRef, int n) {
		assert numtestRef.test(n) : "Not Valid 0";
	}

}
