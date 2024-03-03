package com.demo.lambdas;
//If a string is passed the it will return all caps

//If a number is passed then it will returns square

interface GenInterface<T> {
	T operation(T t);
}

public class GenericLambdaDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// declare two reference of the Interface
		GenInterface<Integer> genInterfaceInt;
		GenInterface<String> genInterfaceStr;

		genInterfaceInt = (n) -> n * n;
		genInterfaceStr = (str) -> str.toUpperCase();

		System.out.println("For the integer type: " + genInterfaceInt.operation(10));
		System.out.println("For the string type: " + genInterfaceStr.operation("soumya"));

	}

}
