package com.demo.lambdas;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Pojo implements Serializable {
	// simple pojo class multiple different attributes

	private String name;
	private String age;
	private String location;
	private String dob;

	public Pojo(String name, String age, String location, String dob) {
		super();
		this.name = name;
		this.age = age;
		this.location = location;
		this.dob = dob;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Pojo [name=" + name + ", age=" + age + ", location=" + location + ", dob=" + dob + "]";
	}

}

class MyComapare implements Comparator<Pojo> {

	@Override
	public int compare(Pojo o1, Pojo o2) {
		// TODO Auto-generated method stub

		int age1 = Integer.parseInt(o1.getAge());
		int age2 = Integer.parseInt(o2.getAge());

		if (age1 == age2) {
			return 0;
		} else if (age1 > age2)
			return -1;

		else if (age1 < age2)
			return 1;

		return -1;
	}
}

public class StreamsDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		List<Integer> numList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		Iterator<Integer> itr = numList.iterator();
		// Comparator class object
		MyComapare myComapare = new MyComapare();
		// using forEach
		while (itr.hasNext()) {
			System.out.println(itr.next());

		}

		// stream
		numList.forEach(System.out::print);

		Consumer<Integer> printList = (n) -> {
			System.out.print(n + " ");
		};
		numList.forEach(printList);

		// Merge two streams and get the unique item
		Stream<Integer> firstStream = Stream.of(1, 2, 3, 4, 5);
		Stream<Integer> secondStream = Stream.of(4, 5, 6);

		Stream<Integer> concatStream = Stream.concat(firstStream, secondStream).distinct();
		System.out.println("Concatenated Streams");
		concatStream.forEach(printList);

		// Demo filtering out records on the basis of their location
		Stream<Pojo> employee1 = getEmployeeList1().stream();
		Stream<Pojo> employee2 = getEmployeeList2().stream();

		Stream<Pojo> resultingStream = Stream.concat(employee1, employee2).filter(distinctByLocaltion());
		// resultingStream.collect(Collectors.toList()).forEach(System.out::print);

		// sorting using stream and comparator
		Stream<Pojo> employee3 = getEmployeeList1().stream();
		employee3.sorted(myComapare::compare).forEach(System.out::println);
		// employee3.sorted(myComapare.reversed()).forEach(System.out::println); // the
		// reverse returns a comparator
		listToMapDemo1();
		listToMapDemo2();
		listToMapDemo3();
		mapToListDemo();

	}

	private static <T> Predicate<T> distinctByLocaltion() {
		Map<Object, Boolean> map = new ConcurrentHashMap<>();
		Function<Pojo, String> keyExtrcator = (t) -> {
			return t.getLocation();
		};
		Predicate<T> filterPriPredicate = (t) -> map.putIfAbsent(keyExtrcator, Boolean.TRUE) == null;

		return filterPriPredicate;

	}
	// alternate implementation

	private static <T> Predicate<T> distinctByLocaltion2(Function<? super T, Object> keyExtractor) {
		Map<Object, Boolean> map = new ConcurrentHashMap<>();

		Predicate<T> filterPriPredicate = (t) -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE);

		return filterPriPredicate;

	}

	private static List<Pojo> getEmployeeList1() {
		List<Pojo> list1 = new LinkedList<>();
		list1.add(new Pojo("Abcd1", "25", "IND", "03081997"));
		list1.add(new Pojo("Abcd2", "24", "USA", "03081997"));
		list1.add(new Pojo("Abcd3", "23", "UK", "03081997"));
		list1.add(new Pojo("Abcd4", "27", "IND", "03081997"));

		return list1;
	}

	private static List<Pojo> getEmployeeList2() {
		List<Pojo> list1 = new LinkedList<>();
		list1.add(new Pojo("Efgh1", "27", "USA", "03081997"));
		list1.add(new Pojo("Efgh2", "35", "USA", "03081997"));
		list1.add(new Pojo("Efgh3", "22", "USA", "03081997"));
		list1.add(new Pojo("Efgh4", "26", "IND", "03081997"));

		return list1;
	}

	private static void listToMapDemo1() {

		// The function to get the keys for the Map
		Function<Pojo, String> getKeyFunction = (Pojo p) -> {
			return p.getLocation();
		};
		// The function to get the values for the Map
		Function<Pojo, String> getValueFunction = (Pojo p) -> {
			return p.getAge();
		};
		// to merge and resolve conflict in case keys could have multiple values
		BinaryOperator<String> mergeAgesBinaryOperator = (age1, age2) -> age1 + ',' + age2;

		// supplies new Map
		Supplier<Map<String, String>> mapFactorySupplier = () -> new HashMap<String, String>();
		getEmployeeList1().stream()
				.collect(
						Collectors.toMap(getKeyFunction, getValueFunction, mergeAgesBinaryOperator, mapFactorySupplier))
				.forEach((key, values) -> {
					System.out.println(key + ":" + values);
				});

	}

	private static void listToMapDemo2() {

		// The function to get the keys for the Map
		Function<Pojo, String> getKeyFunction = (Pojo p) -> {
			return p.getLocation();
		};
		// The function to get the values for the Map
		Function<Pojo, String> getValueFunction = (Pojo p) -> {
			return p.getAge();
		};
		// to merge and resolve conflict in case keys could have multiple values
		BinaryOperator<String> mergeAgesBinaryOperator = (age1, age2) -> age1 + ',' + age2;

		// supplies new Map
		Supplier<Map<String, String>> mapFactorySupplier = () -> new HashMap<String, String>();
		// using method reference
		getEmployeeList1().stream()
				.collect(Collectors.toMap(Pojo::getLocation, Pojo::getAge, mergeAgesBinaryOperator, mapFactorySupplier))
				.forEach((key, values) -> {
					System.out.println(key + ":" + values);
				});

	}

	private static void listToMapDemo3() {

		// The function to get the keys for the Map
		Function<Pojo, String> getKeyFunction = (Pojo p) -> {
			return p.getLocation();
		};
		// The function to get the values for the Map
		Function<Pojo, List<String>> getValueFunction = (Pojo p) -> {
			return Arrays.asList(p.getAge());
		};
		// to merge and resolve conflict in case keys could have multiple values
		BinaryOperator<String> mergeAgesBinaryOperator = (age1, age2) -> age1 + ',' + age2;

		// supplies new Map
		Supplier<Map<String, String>> mapFactorySupplier = () -> new HashMap<String, String>();

		// create the map of list
		getEmployeeList1().stream()
				.collect(Collectors.groupingBy(getKeyFunction, Collectors.mapping(Pojo::getAge, Collectors.toList())))
				.forEach((key, values) -> {
					System.out.println(key + ":" + values);
				});

	}

	private static void mapToListDemo() {
		// The function to get the keys for the Map
		Function<Pojo, String> getKeyFunction = (Pojo p) -> {
			return p.getLocation();
		};
		// The function to get the values for the Map
		Function<Pojo, String> getValueFunction = (Pojo p) -> {
			return p.getAge();
		};
		// to merge and resolve conflict in case keys could have multiple values
		BinaryOperator<String> mergeAgesBinaryOperator = (age1, age2) -> age1 + ',' + age2;

		// supplies new Map
		Supplier<Map<String, String>> mapFactorySupplier = () -> new HashMap<String, String>();
		Map<String, String> map = getEmployeeList1().stream().collect(
				Collectors.toMap(getKeyFunction, getValueFunction, mergeAgesBinaryOperator, mapFactorySupplier));

		// map.entrySet().stream().forEach(each -> System.out.println(each.getKey()));

		List<String> keyStrings = new ArrayList<>();
		List<String> valStrings = new ArrayList<>();
		map.entrySet().stream().forEach((eachEntry) -> {
			keyStrings.add(eachEntry.getKey());
			valStrings.add(eachEntry.getValue());
		});

	}

}
