package com.DemoCollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

//demonstartion of different hashset methods
public class HashSetDemoDriver {
	public static void addInSet() {
		// UNION operation
		Integer[] A = { 22, 45, 33, 66, 55, 34, 77 };
		Integer[] B = { 33, 2, 83, 45, 3, 12, 55 };
		Set<Integer> set1 = new HashSet<Integer>();
		set1.addAll(Arrays.asList(A));
		Set<Integer> set2 = new HashSet<Integer>();
		set2.addAll(Arrays.asList(B));

		// Finding Union of set1 and set2
		Set<Integer> union_data = new HashSet<Integer>(set1);
		union_data.addAll(set2);
		System.out.print("Union of set1 and set2 is:");
		System.out.println(union_data);

		// Finding Intersection of set1 and set2
		Set<Integer> intersection_data = new HashSet<Integer>(set1);
		intersection_data.retainAll(set2);
		System.out.print("Intersection of set1 and set2 is:");
		System.out.println(intersection_data);

		// Finding Difference of set1 and set2
		Set<Integer> difference_data = new HashSet<Integer>(set1);
		difference_data.removeAll(set2);
		System.out.print("Difference of set1 and set2 is:");
		System.out.println(difference_data);

	}

	public static void addElem() {
		Set<Integer> data = new LinkedHashSet<Integer>();
		data.add(31);
		data.add(21);
		data.add(41);
		data.add(11);
		data.add(61);
		data.add(51);
		System.out.println("data: " + data);

		// addAll()
		Set<Integer> data1 = new LinkedHashSet<Integer>();
		data1.add(31);
		data1.add(21);
		data1.add(41);
		System.out.println("Set: " + data1);
		ArrayList<Integer> newData = new ArrayList<Integer>();
		newData.add(91);
		newData.add(71);
		newData.add(81);
		data1.addAll(newData);
		System.out.println("Set: " + data1);
	}

	public static void retainSet() {
		// Intersection operation

	}

	public static void removeSet() {
		// DIFFERENCE operation

	}

	public static void removeAllElements() {
		// clear()
		Set<Integer> data = new LinkedHashSet<Integer>();
		data.add(31);
		data.add(21);
		data.add(41);
		data.add(51);
		data.add(11);
		data.add(81);
		System.out.println("data: " + data);

		data.remove(81);
		data.remove(21);
		data.remove(11);
		System.out.println("data after removing elements: " + data);
		ArrayList<Integer> newData = new ArrayList<Integer>();
		newData.add(91);
		newData.add(71);
		newData.add(81);
		System.out.println("NewData: " + newData);

		data.removeAll(newData);
		System.out.println("data after removing Newdata elements : " + data);
	}

	public static void checkElem() {
		Set<Integer> data = new LinkedHashSet<Integer>();
		data.add(31);
		data.add(21);
		data.add(41);
		data.add(51);
		data.add(11);
		data.add(81);
		System.out.println("Set: " + data);
		System.out.println("Does the Set contains '91'?" + data.contains(91));
		System.out.println("Does the Set contains 'javaTpoint'? " + data.contains("4"));
		System.out.println("Does the Set contains '51'? " + data.contains(51));

		Set<Integer> data1 = new LinkedHashSet<Integer>();
		data1.add(31);
		data1.add(21);
		data1.add(41);
		data1.add(51);
		data1.add(11);
		data1.add(81);

		System.out.println("data: " + data1);

		Set<Integer> newData = new LinkedHashSet<Integer>();
		newData.add(31);
		newData.add(21);
		newData.add(41);

		System.out.println("\nDoes data contains newData?: " + data1.containsAll(newData));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
