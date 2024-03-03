package com.stream_demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemoDriver {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		// works best with Collections or Arrays
		ArrayList<Integer> arrayList = new ArrayList<>();

		for (int i = 0; i <= 20; ++i) {
			arrayList.add(i);// random returns double
		}
		System.out.println("Showing the List:");

		arrayList.forEach(each_element -> System.out.print(each_element + " "));

		// creating a stream reference
		Stream<Integer> arrStream = arrayList.stream();

		// get the maximum element inside the ArrayList
		// the max takes a comparator
		// here we have passed a method reference of that comparator and did not
		// implement any
		Optional<Integer> maxArrayList = arrStream.max(Integer::compare); // returns a optinal after a terminal
		if (maxArrayList.isPresent()) {
			System.out.println("Maximum element in the array is:" + maxArrayList.get());
		} else {
			System.out.println("Not found");
		}

		// reduce and filter

		Stream<Integer> evenArrayList = arrayList.stream().filter((each_element) -> each_element % 2 == 0);
		// returns a Stream
		System.out.println("Displaying even numbers from stream");
		evenArrayList.forEach(each_element -> System.out.print(each_element + " "));
		System.out.println();
		// or define the Predicate
		Predicate<Integer> oddNumCheckPredicate = (n) -> {
			return (n % 2 == 1);
		};
		Predicate<Integer> getGreaterThanTwo = (n) -> {
			return n > 2;
		};

		Stream<Integer> oddArrayList = arrayList.stream().filter(oddNumCheckPredicate);
		// returns a Stream
		System.out.println("Displaying odd numbers from stream");
		oddArrayList.forEach(each_element -> System.out.print(each_element + " "));
		// or define the Predicate.and(Predicate)
		// chain the predicates
		Stream<Integer> oddArrayList2 = arrayList.stream().filter(oddNumCheckPredicate.and(getGreaterThanTwo));
		// returns a Stream
		System.out.println("Displaying odd numbers greater than 2 from stream");
		oddArrayList2.forEach(each_element -> System.out.print(each_element + " "));

		// reduce takes BinaryOpearation

		Optional<Integer> sumOfOddElemens = arrayList.stream().reduce((curr, next) -> curr + next);
		if (sumOfOddElemens.isPresent())
			System.out.println("Sum of all the odd elements: " + sumOfOddElemens.get());
		else {
			System.out.println("Not found");
		}

		// map BiFunction
		// map the elements of the existing list into another list (square of each
		// numbers)
		Stream<Integer> sqArrayList = arrayList.stream().map((each_element) -> (int) Math.pow(each_element, 2));

		// display the stream
		sqArrayList.forEach((each_element) -> System.out.print(each_element + ","));

		// collector=>creating collections from a stream
		/*
		 * Create an array of repeating elements then take the odd numbers then create a
		 * set to get the unique elements Using the Collections.toSet()
		 */

		List<Integer> nums = new ArrayList<Integer>();
		nums.add(2);
		nums.add(3);
		nums.add(3);
		nums.add(13);
		nums.add(23);
		nums.add(33);
		nums.add(103);
		nums.add(103);
		nums.add(13);
		nums.add(13);
		nums.add(13);

		int totalElemens = (int) nums.stream().count();
		System.out.println("Total number of elements in the stream is: " + totalElemens);

		Set<Integer> uniqueNumbSet = nums.stream().filter(oddNumCheckPredicate).collect(Collectors.toSet());
		uniqueNumbSet.forEach((eacn_odds) -> System.out.print(eacn_odds + ","));

		predicateDemo();
		// find index of an element in List using stream api

		findIndexOfElem();

		// sort a map
		sortHashMap();
	}

	private static void sortHashMap() {
		Map<String, Integer> map = new HashMap<>();
		map.put("Alice", 30);
		map.put("Bob", 25);
		map.put("Charlie", 40);

		// Create a new LinkedHashMap to preserve insertion order
		Map<String, Integer> sortedMap = map.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(
				Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (key1, key2) -> key1, LinkedHashMap::new));

		System.out.println(sortedMap);
	}

	private static void findIndexOfElem() {
		List<Integer> intList = List.of(1, 2, 3, 4, 5);

		int index = IntStream.range(0, intList.size()).filter((i) -> intList.get(i) == 4).findFirst().orElse(-1);
		System.out.println("Index was found at: " + index);
	}

	private static void predicateDemo() {

		Predicate<Boolean> ifNullElem = (s) -> s == null;
		Predicate<Boolean> isNullElem = (s) -> s != null;
		Predicate<Boolean> checkNull = (s) -> ifNullElem.test(s) == false;

		System.out.println("Here it is:" + checkNull.test(null));

	}

	private void testCustomCollector() {

	}
}
