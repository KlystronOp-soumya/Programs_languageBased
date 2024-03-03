package com.fresco.play;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class LambdaFn {

	@SuppressWarnings("deprecation")
	public List<Long> functionalProgramming(List<String> listOfIntegers) {
		// Write your code here
		// define a Predicate for filtration always a boolean valued function
		Predicate<Integer> kaprekarNumberCheckPredicate = (n) -> {
			if (n == 1)
				return true;

			int c = 0;
			int sq = n * n;

			while (sq != 0) {
				c++;
				sq /= 10;

			}
			// recompute
			sq = n * n;

			for (int r_dig = 1; r_dig <= c; ++r_dig) {
				int eq_part = (int) Math.pow(10, r_dig);
				if (eq_part == n)
					continue; // for 10,100,1000 etc

				int sum = sq / eq_part + sq % eq_part;

				if ((sum ^ n) == 0)
					return true;
			}
			return false;
		};

		// define a Function for the map opearation
		Function<String, Integer> convertToInt = (str) -> {
			return Integer.parseInt(str);
		};

		Stream<Integer> numbers = listOfIntegers.stream().map(eachStr -> Integer.parseInt(eachStr));

		List<Long> outputList = Collections.emptyList();

		outputList = numbers.filter(kaprekarNumberCheckPredicate).mapToLong(Long::new).boxed()
				.collect(Collectors.toList());

		outputList.stream().forEach((e) -> System.out.println(e));
		return outputList;
	}

}

public class FrescoLambdaStreamSolution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LambdaFn objeFn = new LambdaFn();
		List<String> iStrings = new ArrayList<>();

		for (int i = 1; i <= 99; ++i) {
			iStrings.add(String.valueOf(i));
		}

		objeFn.functionalProgramming(iStrings);

		/*
		 * for (String string : iStrings) System.out.println(string);
		 */
	}

}
