package com.DemoCollection;

//hashmap with forEach is at com.stringDemo

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 * Get the set of the keys-> Set<integer> s =hm.keySet()
 * python setDefault=> hm.getOrDefault(c,0)*/

public class HashMapDriver {

	@SuppressWarnings({ "rawtypes", "unused" })
	public static void sortMap() {
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		hm.put(6, "Tushar");
		hm.put(12, "Ashu");
		hm.put(5, "Zoya");
		hm.put(78, "Yash");
		hm.put(10, "Praveen");
		hm.put(67, "Boby");
		hm.put(1, "Ritesh");

		// displaying the hashmap items
		/*
		 * System.out.println("Before Sorting:"); Set set = hm.entrySet(); Iterator
		 * iterator = set.iterator(); while(iterator.hasNext()) { Map.Entry map =
		 * (Map.Entry)iterator.next();
		 * System.out.println("Roll no:  "+map.getKey()+"     Name:   "+map.getValue());
		 * }
		 */
		System.out.println("HashMap before sorting");
		for (Map.Entry m : hm.entrySet()) {
			System.out.println("Roll no:  " + m.getKey() + "     Name:   " + m.getValue());
		}
		@SuppressWarnings("unchecked")
		HashMap<Integer, String> hm2 = sortByValues(hm);
		System.out.println("HashMap before sorting");
		for (Map.Entry m : hm2.entrySet()) {
			System.out.println("Roll no:  " + m.getKey() + "     Name:   " + m.getValue());
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static HashMap sortByValues(HashMap map) {
		List list = new LinkedList(map.entrySet());
		// Defined Custom Comparator here
		Collections.sort(list, new Comparator() {
			public int compare(Object o1, Object o2) {
				return ((Comparable) ((Map.Entry) (o1)).getValue()).compareTo(((Map.Entry) (o2)).getValue());
			}
		});

		// Here I am copying the sorted list in HashMap
		// using LinkedHashMap to preserve the insertion order
		HashMap sortedHashMap = new LinkedHashMap();
		for (Iterator it = list.iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry) it.next();
			sortedHashMap.put(entry.getKey(), entry.getValue());
		}
		return sortedHashMap;
	}

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer, String> map = new HashMap<Integer, String>();// Creating HashMap
		map.put(1, "Mango"); // Put elements in Map
		map.put(2, "Apple");
		map.put(3, "Banana");
		map.put(4, "Grapes");

		System.out.println("Iterating Hashmap...");
		for (Map.Entry m : map.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());

		}

		// add elements in hashmap
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		System.out.println("Initial list of elements: " + hm);
		hm.put(100, "Amit");
		hm.put(101, "Vijay");
		hm.put(102, "Rahul");

		System.out.println("After invoking put() method ");
		for (Map.Entry m : hm.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
		}

		hm.putIfAbsent(103, "Gaurav");
		System.out.println("After invoking putIfAbsent() method ");
		for (Map.Entry m : hm.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
		}

		HashMap<Integer, String> map1111 = new HashMap<Integer, String>();
		map1111.put(104, "Ravi");
		map1111.putAll(hm); // adding the elements of one map to another map
		System.out.println("After invoking putAll() method ");

		for (Map.Entry m : map.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
		}

		// remove elements from a map
		HashMap<Integer, String> map1 = new HashMap<Integer, String>();
		map1.put(100, "Amit");
		map1.put(101, "Vijay");
		map1.put(102, "Rahul");
		map1.put(103, "Gaurav");
		System.out.println("Initial list of elements: " + map1);
		// key-based removal
		map1.remove(100);
		System.out.println("Updated list of elements: " + map1);
		// value-based removal
		map1.remove(101);
		System.out.println("Updated list of elements: " + map1);
		// key-value pair based removal
		map1.remove(102, "Rahul");
		System.out.println("Updated list of elements: " + map1);

		// replace elements
		HashMap<Integer, String> hm1 = new HashMap<Integer, String>();
		hm1.put(100, "Amit");
		hm1.put(101, "Vijay");
		hm1.put(102, "Rahul");
		System.out.println("Initial list of elements:");
		for (Map.Entry m : hm1.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
		}
		System.out.println("Updated list of elements:");
		hm1.replace(102, "Gaurav");
		for (Map.Entry m : hm1.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
		}
		System.out.println("Updated list of elements:");
		hm1.replace(101, "Vijay", "Ravi");
		for (Map.Entry m : hm1.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
		}
		System.out.println("Updated list of elements:");
		hm1.replaceAll((k, v) -> "Ajay");
		for (Map.Entry m : hm1.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());

		}

		// Iterate over HashMap in java
//Using Iterator interface
		HashMap<Integer, String> hm11 = new HashMap<Integer, String>(); // implements map interface
		hm11.put(110, "Ravi");
		hm11.put(120, "Prateek");
		hm11.put(130, "Davesh");
		hm11.put(140, "Kamal");
		hm11.put(150, "Pawan");
		Iterator<Integer> it = hm11.keySet().iterator(); // keyset is a method
		while (it.hasNext()) {
			int key = (int) it.next();
			System.out.println("Roll no.: " + key + "     name: " + hm11.get(key));
		}

		// keystet() and value()
		Map<String, String> map11 = new HashMap<String, String>();
		map11.put("Gujarat", "Gandhi Nagar");
		map11.put("Uttar Pradesh", "Lucknow");
		map11.put("Sikkim", "Ganagtok");
		for (String State : map11.keySet()) // using keyset() method for iteration over keySet
			System.out.println("State: " + State);
		for (String Capital : map11.values()) // using values() for iteration over keys
			System.out.println("Capiatl: " + Capital);

		// Using Map entry
		Map<String, Float> map111 = new HashMap<String, Float>();
		map111.put("Cookies", 90.87f);
		map111.put("Dry Fruits", 434.23f);
		map111.put("Oats", 220.00f);
		map111.put("Chocolate", 70.89f);
		// the <String,Float> is not required
		for (Map.Entry<String, Float> entry : map111.entrySet()) // using map.entrySet() for iteration
		{
			// returns keys and values respectively
			System.out.println("Item: " + entry.getKey() + ", Price: " + entry.getValue());
		}

		// check if a key exists in hashmap
		HashMap<Integer, String> hashmap = new HashMap<Integer, String>();

		// Adding Key and Value pairs to HashMap
		hashmap.put(11, "Chaitanya");
		hashmap.put(22, "Pratap");
		hashmap.put(33, "Singh");
		hashmap.put(44, "Rajesh");
		hashmap.put(55, "Kate");

		// Checking Key Existence
		boolean flag = hashmap.containsKey(22);
		System.out.println("Key 22 exists in HashMap? : " + flag);

		boolean flag2 = hashmap.containsKey(55);
		System.out.println("Key 55 exists in HashMap? : " + flag2);

		boolean flag3 = hashmap.containsKey(99);
		System.out.println("Key 99 exists in HashMap? : " + flag3);

		// CHECK IF VALUE IS PRESENT
		HashMap<Integer, String> hashmap1 = new HashMap<Integer, String>();

		// Adding Key and Value pairs to HashMap
		hashmap1.put(11, "Chaitanya");
		hashmap1.put(22, "Pratap");
		hashmap1.put(33, "Singh");
		hashmap1.put(44, "Rajesh");
		hashmap1.put(55, "Kate");

		// Checking Value Existence
		boolean flag1 = hashmap1.containsValue("Singh");
		System.out.println("String Singh exists in HashMap? : " + flag1);

	}

}
