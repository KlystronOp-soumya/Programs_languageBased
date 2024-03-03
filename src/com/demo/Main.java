package com.demo;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		/*
		 * String str = "abc"; // List<String> strings = new ArrayList<>() ; String temp
		 * = ""; for (int i = str.length() - 1; i >= 0; i--) { temp += str.charAt(i); }
		 * System.out.println(temp); String str2 = "1234"; int i =
		 * Integer.parseInt(str2);
		 */

		List<Integer> intList = new ArrayList<>();
		intList.add(1);
		intList.add(2);
		intList.add(3);
		intList.add(4);
		intList.add(5);

		intList.stream().forEach((eachInt) -> System.out.println(eachInt));
		// DB2 -> driver -- AS400 console 5250 / IBM iaccess client
		// Class.forName()
		// Connection conn - driverMngr.getConnection() ;
		// Statement
		//

		/*--- Insertion ---*/
		// Spring Batch -- chunk based (500) -- writer
	}

}
