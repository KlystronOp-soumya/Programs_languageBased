package com.demo.lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class PredefinedFuntionalInterfaceDemo {
	public static void main(String[] args) {
		// demostration of predefined functional interfaces
		// Function<T,R>

		Function<Integer, Integer> factorial = (n) -> {
			int fact = 1;
			for (int i = 1; i <= n; ++i) {
				fact *= i;
			}
			return fact;

		};

		System.out.println("Using a Predefined Functional Interface: ");
		System.out.println("Factorial of 5 is: " + factorial.apply(5));

		// Supplier<T> only supplies

		Supplier<String> exceptionSupplier = () -> "this is an exception";

		System.out.println("Using Supplier functional interface");
		System.out.println("The exception is: " + exceptionSupplier.get());
		// Consumer<T>
		Consumer<Integer> consumer = (a) -> System.out.println(a * a);
		System.out.println("Using Consumer Functional Interface");
		System.out.println("Square of 5 is: ");
		consumer.accept(5);
		Consumer<String> consumerDisplay = (message) -> System.out.println("Completed " + message);
		consumerDisplay.accept("This is functional interface");

		// Consumer to multiply 2 to every integer of a list
		Consumer<List<Integer>> modify = list -> {
			for (int i = 0; i < list.size(); i++)
				list.set(i, 2 * list.get(i));
		};

		// Consumer to display a list of integers
		@SuppressWarnings("unused")
		Consumer<List<Integer>> dispList = list -> list.stream().forEach(a -> System.out.print(a + " "));

		List<Integer> list = new ArrayList<Integer>();
		list.add(2);
		list.add(1);
		list.add(3);
		try {
			// using addThen()
			modify.andThen(dispList).accept(list);
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}

	}
}
