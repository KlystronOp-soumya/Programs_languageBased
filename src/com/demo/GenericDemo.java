package com.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GenericDemo {

	public static void main(String[] args) {

		Supplier<Integer> randomNumSupplier = () -> new Random().nextInt(10, 20);
		List<Integer> numList = IntStream.rangeClosed(0, 20).map((i) -> i * randomNumSupplier.get())
				.collect(ArrayList::new, ArrayList::add, ArrayList::addAll); // generates random list
		Map<String, Long> genMap2 = numList.stream().map(eachNum -> String.valueOf(eachNum))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		System.out.println(genMap2);

		Map<String, ?> genMap = new HashMap<>(genMap2);

	}

}
