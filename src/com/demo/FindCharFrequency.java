package com.demo;

import java.util.HashMap;
import java.util.Map;

public class FindCharFrequency {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String st = "HelloWorld";
		HashMap<Character, Integer> freqHashMap = new HashMap<Character, Integer>();

		for (int i = 0; i < st.length(); ++i) {
			if (freqHashMap.containsKey(st.charAt(i))) {
				freqHashMap.put(st.charAt(i), freqHashMap.get(st.charAt(i)) + 1);
			} else {
				freqHashMap.put(st.charAt(i), 1);
			}

		}

		// display
		for (Map.Entry m : freqHashMap.entrySet()) {
			System.out.println("charachter: " + m.getKey() + " occurred:" + m.getValue());
		}

	}

}
