package com.stream_demo;

import java.util.HashMap;

public final class HashMapStreamDemo {

	static boolean comapreSTM(Float obj1, Float obj2) {
		return obj1 < obj2;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// define a hashMap
		HashMap<String, Float> students = new HashMap<>();

		for (int i = 90, j = 65; i <= 100; ++i, ++j) {
			char temp = (char) j;
			String refString = String.valueOf(temp);
			students.put(refString, (float) i);
		}

		System.out.println("Showing Student details--->");
		students.forEach((key, value) -> System.out.println("Name: " + key + " Marks: " + value));

	}

}
