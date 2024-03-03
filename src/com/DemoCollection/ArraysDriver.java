package com.DemoCollection;

import java.util.Arrays;
import java.util.List;

/*This file demonstrates the diffrent functions of the Arrays Class*/
public class ArraysDriver {
	public static void main(String[] args) {
		// covert an array to list
		String[] strings = { "one", "two", "three", "four", "five" };
		// strings array is converted into a List
		// converting an array to list
		List<String> list = Arrays.asList(strings);
		System.out.println(list);

		// sort the array
		char[] chars = { 'B', 'D', 'C', 'A', 'E' };
		Arrays.sort(chars);
		System.out.print("Sorted Characters : ");
		for (char character : chars) {
			System.out.print(character + " ");
		}

		// Sorting Integer
		int[] integers = { 5, 2, 1, 4, 3 };
		Arrays.sort(integers);
		System.out.print("\nSorted Integers : ");
		for (int i : integers) {
			System.out.print(i + " ");
		}

		// Sorting Specific Range of Integers
		int[] ints = { 5, 2, 1, 4, 3, 9, 6, 8, 7, 10 };
		int fromIndex = 2;
		int toIndex = 7;
		Arrays.sort(ints, fromIndex, toIndex);
		System.out.print("\nSorted Integers of Specific Range : ");
		for (int i : ints) {
			System.out.print(i + " ");
		}

		// Binary Search
		// Searching a value from array of integer
		/*
		 * int[] integers = { 5, 2, 1, 4, 3, 9, 6, 8, 7, 10 }; int index =
		 * Arrays.binarySearch(integers, 2); if (index >= 0) {
		 * System.out.println("Element is found at the index :" + index); } else {
		 * System.out.println("Element is not found"); }
		 * 
		 * // Searching a value from array of integer with specific range int fromIndex
		 * = 2; int toIndex = 7; int index2 = Arrays.binarySearch(integers, fromIndex,
		 * toIndex, 9); if (index2 >= 0) {
		 * System.out.println("Element is found at the index :" + index2); } else {
		 * System.out.println("Element is not found"); }
		 */

		// fill an array with values
		boolean[] bool_ar = new boolean[15];
		boolean val = true;
		Arrays.fill(bool_ar, val);
		for (boolean v : bool_ar) {
			System.out.println(v);
		}
		Arrays.fill(bool_ar, 1, 8, false);

	}// main

}
