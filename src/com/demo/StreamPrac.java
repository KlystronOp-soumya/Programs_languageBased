package com.demo;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class Movie implements Comparable<Movie> {
	String name;
	float rating;

	public Movie() {

	}

	public Movie(String name, float rating) {
		this.name = name;
		this.rating = rating;
	}

	@Override
	public int compareTo(Movie nextMovie) {

		return Float.compare(this.rating, nextMovie.rating);
	}

	@Override
	public String toString() {
		return "Movie [name=" + name + ", rating=" + rating + "]";
	}

}

class Employee {
	int id;
	String name;
	int age;
	float ctc;

	public Employee() {

	}

	public Employee(int id, String name, float ctc) {
		this.id = id;
		this.name = name;
		this.ctc = ctc;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", ctc=" + ctc + "]";
	}

}

class EmployeeComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {

		return Float.compare(o1.ctc, o2.ctc);
	}

	public int compareByAge(Employee o1, Employee o2) {
		return Integer.compare(o1.age, o2.age);
	}

}

public class StreamPrac {

	private static Writer out = null;

	static {
		out = new BufferedWriter(new OutputStreamWriter(System.out));

	}

	private static void write(final String thisObj) {

		try {
			out.write(thisObj);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		out.flush();
		List<Movie> moviesList = Arrays.asList(new Movie("ghi", 4.8f), new Movie("abc", 3.8f), new Movie("jkl", 3.5f),
				new Movie("def", 3.9f), new Movie("pqr", 4.8f), new Movie("bef", 4.2f), new Movie("deg", 3.5f));
		/*
		 * Optional<Movie> optMovie = Optional.ofNullable(
		 * moviesList.stream().filter((eachMovie) ->
		 * eachMovie.name.contains("abc")).findFirst().orElseThrow());
		 * write(optMovie.get().toString());
		 */
		Stream<Movie> moviesStream = moviesList.stream();
		Comparator<Movie> byName = Comparator.comparing((m) -> m.name);
		Comparator<Movie> byNameReverse = byName.reversed();
		// moviesStream.forEach(e -> write(e.toString()));
		write("After sorting\n");
		moviesStream.sorted(byNameReverse).forEach(e -> write(e.toString()));

		// create a map
		Function<Movie, Map<String, Float>> movieMapperFunction = (movie) -> {

			Map<String, Float> map = new HashMap<>();
			map.put(movie.name, movie.rating);
			return map;
		};
		Stream<Movie> moviesStream2 = moviesList.stream();
		Stream<Map<String, Float>> mappedStream = moviesStream2.map(movieMapperFunction);

		mappedStream.forEach(e -> e.entrySet().forEach(t -> write(t.getKey() + "->" + t.getValue() + "\n")));

		// group by
		System.out.println("Grouping the movies based on rating::\n"
				+ moviesList.stream().collect(Collectors.groupingBy((eachMovie) -> eachMovie.rating)));

		List<Integer> numList = Arrays.asList(1, 2, 2, 2, 3, 3, 4, 5, 5, 5, 5, 5, 5, 6, 7, 7, 8, 9, 8, 8);
		// get the distinct
		numList.stream().distinct().forEach(e -> write(e + "\n\n")); // prints the distinct elems

		List<Integer> uniqueList = numList.stream().distinct().collect(Collectors.toList());
		System.out.println(uniqueList);

		// find the repeated element
		Map<String, Long> freqMap = numList.stream()
				.collect(Collectors.groupingBy(eachNum -> String.valueOf(eachNum), Collectors.counting()));

		// sort the entries by key
		freqMap.entrySet().stream().sorted(Map.Entry.comparingByKey())
				.forEach((eachEntry) -> write("Key-> " + eachEntry.getKey() + " : " + eachEntry.getValue() + "\n"));

		// write(freqMap.toString());

		// get the max value
		Entry<String, Long> maxFreqMap = freqMap.entrySet().stream().max(Map.Entry.comparingByValue()).get();

		write("Max map: " + maxFreqMap.toString());

		// find the second largest element from the numList above
		// step 1 : get the distinct elements
		// step 2 : sort the stream in reverse order
		// step 3 : skip the first element
		// step 4: then find the first
		write("\n"
				+ numList.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().get().toString());

		// convert itearable to Stream
		Iterable<String> iterable = Arrays.asList("Testing", "Iterable", "conversion", "to", "Stream");

		List<String> result = StreamSupport.stream(iterable.spliterator(), false).map(String::toUpperCase)
				.collect(Collectors.toList());

		// revrese a string in strem
		String str = "abc";

		String stream = Stream.of(str).map((s) -> new StringBuffer(s).reverse()).collect(Collectors.joining())
				.toString();
		write("Reversed using stream : " + stream);

		// convert String to list then using stream
		List<String> listStrings = new ArrayList<>(Arrays.asList(str));

		String s = listStrings.stream().map((ch) -> ch.toUpperCase()).collect(Collectors.joining("_"));
		write("Here S :" + s);

		String st = "Hello";
		List<String> strings = new ArrayList<>();

		for (int i = 0; i < st.length(); i++) {
			System.out.println("This:" + st.charAt(i));
			strings.add(String.valueOf(st.charAt(i)));
		}

		try {
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
