package com.stream_demo;

import static java.util.stream.Collectors.toList;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import com.stream_demo.Dish.Type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
 * Contains examples from the Lambdas in Modern Java
 * */
//Domain class Dish
@Getter
@Setter
@AllArgsConstructor
@ToString
final class Dish {

	private final String name;
	private final boolean vegeterian;
	private final int calories;
	private final Type type;
	private final double price;

	public enum Type {
		MEAT, FISH, OTHER;
	}

}

// Comparator class for Dish calories
class DishComparator implements Comparator<Dish> {

	@Override
	public int compare(Dish o1, Dish o2) { // Overridden method
		return Integer.compare(o1.getCalories(), o2.getCalories());
	}

	/*
	 * Static method to check the longest names for comparison
	 */
	public static int compareDishNames(Dish d1, Dish d2) {
		return d1.getName().compareTo(d2.getName());
	}

}

public class StreamInDepth {

	private static final Logger log = Logger.getLogger("mylogger");

	static void enumsDemo() {
		// print the associated Ordinal values
		Type[] types = Dish.Type.values();
		for (Type type : types) {
			System.out.println("Name: " + type.name().toString());
			System.out.println("With ordinal: " + type.ordinal());
		}
	}

	static List<Dish> getData() {
		return List.of(new Dish("pork", false, 800, Dish.Type.MEAT, 10.00D),
				new Dish("beef", false, 700, Dish.Type.MEAT, 15.25D),
				new Dish("chicken", false, 400, Dish.Type.MEAT, 5.00D),
				new Dish("french fries", true, 530, Dish.Type.OTHER, 2.00D),
				new Dish("rice", true, 350, Dish.Type.OTHER, 1.00D),
				new Dish("season fruit", true, 120, Dish.Type.OTHER, 6.00D),
				new Dish("pizza", true, 550, Dish.Type.OTHER, 12.00D),
				new Dish("prawns", false, 300, Dish.Type.FISH, 10.00D),
				new Dish("salmon", false, 450, Dish.Type.FISH, 14.58D),
				new Dish("chicken butter masala", false, 590, Dish.Type.MEAT, 3.00D),
				new Dish("butter naan", true, 120, Dish.Type.OTHER, 1.00D));
	}

	static void display(Collection<?> object) {
		object.stream().forEach(System.out::println);
	}

	public static void main(String[] args) {
		log.setLevel(Level.INFO);
		// enumsDemo();

		// get three high calorie dish names >300
		Predicate<Dish> checkHighCalorie = (Dish d) -> d.getCalories() > 300; // using Lambda expression
		Predicate<Dish> checkCalorieLevel = new Predicate<Dish>() { // using anonymous class

			@Override
			public boolean test(Dish t) {
				return t.getCalories() > 300;
			}

		};

		Function<Dish, String> dishNameExtractor = (Dish d) -> d.getName(); // in the map instead of the method
																			// reference this can be used

		getData().stream().filter(checkHighCalorie).map(Dish::getName).limit(3).collect(Collectors.toList()).stream()
				.forEach(System.out::println);
		;

		// debug the code
		getData().stream().filter((d) -> {
			log.info("Filtering : " + d.getName());
			return d.getCalories() > 300;
		}).map((d) -> {

			log.info("Mapping: " + d.getName());
			return d.getName();

		}).limit(3).collect(Collectors.toList()).stream().forEach(System.out::println);
		;

		// slicing the stream -- takewhile and dropwhile
		List<Dish> menus = List.of(new Dish("chicken", false, 400, Dish.Type.MEAT, 5.00D),
				new Dish("french fries", true, 530, Dish.Type.OTHER, 2.00D),
				new Dish("rice", true, 350, Dish.Type.OTHER, 1.00D),
				new Dish("season fruit", true, 120, Dish.Type.OTHER, 6.00D),

				new Dish("prawns", false, 300, Dish.Type.FISH, 10.00D)); // This is a unmodifiable list
		// sort the list based on the calories

		List<Dish> specialMenu = menus.stream().collect(toList()); //change it to mutable list
		specialMenu.sort(Comparator.comparingInt(d -> d.getCalories()));
		List<String> slicedMenu1 = specialMenu.stream().takeWhile((d) -> d.getCalories() < 320).map(d -> d.getName())
				.collect(toList());
		List<String> slicedMenu2 = specialMenu.stream().dropWhile(d -> d.getCalories() < 320).map(d -> d.getName())
				.collect(toList());

		System.out.println(slicedMenu1);
		System.out.println(slicedMenu2);

	}

}
