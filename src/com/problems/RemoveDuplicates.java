package com.problems;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicates {

	public static void main(String[] args) {
		List<Integer> nums = List.of(1, 2, 3, 4, 5, 5, 6, 7, 7, 7, 8, 8, 6, 6, 5);
		// remove duplicates using the stream api
		// nums.stream().distinct().forEach((n) -> System.out.println(n));
		// nums.stream().collect(Collectors.toSet()).stream().forEach(System.out::println);
		Set<Integer> numSet = nums.stream().mapToInt(value -> value).collect(LinkedHashSet<Integer>::new,
				LinkedHashSet::add, LinkedHashSet::addAll);

		numSet.stream().forEach(System.out::print);

		System.out.println(Collections.binarySearch(nums, 3));
	}

}
