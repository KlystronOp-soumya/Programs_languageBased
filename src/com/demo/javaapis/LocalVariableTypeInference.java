/**
 * 
 */
package com.demo.javaapis;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.hibernate.annotations.Check;

/**
 * @author USER
 *
 */
public class LocalVariableTypeInference {

	// not here
	/**
	 * @param args
	 */

	var z = 3; // can not be defined in class block as instance var
	static var a = "apple"; // can not be declared as static

	{
		// init block
		var d = 123.56; // can be initialized in static
		d = 22.4;
		d = "java"; // changing the type in between is not also possible

		var y; // need to define the value in the same line
		y = 5;

		var var = 10; // var is not a reserved keyword
	}

	public LocalVariableTypeInference(var x) {
		var y = 2;

		var j = null; // null can not be assigned

		var z = (String) null; // in order to do so we need to cast the null first
	}

	public static void main(String[] args) {
		// new additon to the Java 11 is the var keyword
		var a = 1; // has to be local and need to initialize on the same line
		var b = 3.96d;
		var c = "Hello world";
		System.out.println(a + "" + b + "" + c);
		check(1); // defining args as var not allowed

	}

	private static void check(var x) {

		int a = 2, b = 3;
		var c = 4, d = 5;

		List<String> ls = new ArrayList<>();

		ls.add("a");
		ls.add("b");
		ls.add("c");

		Predicate<String> removeA = (var ch) -> {
			return ch == "a";
		};

		ls.removeIf(removeA);

	}

}
