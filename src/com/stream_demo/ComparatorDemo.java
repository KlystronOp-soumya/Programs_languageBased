package com.stream_demo;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@FunctionalInterface
interface Perform {
	Object doPerform(Object obj);
}

class Employee {

	String name;
	String userId;
	int age;
	double salary;
	double experience;

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", salary=" + salary + ", experience=" + experience + "]";
	}

}

class EmployeeComparator implements Comparator<Employee> {

	//
	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.name.compareTo(o2.name);
	}

	public int compareByAge(Employee o1, Employee o2) {
		return o1.age > o2.age ? 1 : 0;
	}

	public int compareBySalary(Employee o1, Employee o2) {
		return Double.compare(o1.salary, o2.salary);
	}

}

public class ComparatorDemo {

	private List<Employee> employees;
	final static PrintWriter OUT = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

	public ComparatorDemo() {
		employees = new ArrayList<>();
		Employee e1 = new Employee();
		Employee e2 = new Employee();
		Employee e3 = new Employee();
		Employee e4 = new Employee();
		Employee e5 = new Employee();
		Employee e6 = new Employee();

		e1.name = "Abcd";
		e1.userId = "A1234";
		e1.age = 27;
		e1.salary = 27500D;
		e1.experience = 1.5;

		e2.name = "Bcd";
		e2.userId = "B56789";
		e2.age = 29;
		e2.salary = 30700D;
		e2.experience = 3.1;

		e3.name = "Cdefghj";
		e3.userId = "C9101112";
		e3.age = 27;
		e3.salary = 26900D;
		e3.experience = 2.3;

		e4.name = "Def12";
		e4.userId = "D111211314";
		e4.age = 45;
		e4.salary = 60700D;
		e4.experience = 11;

		e5.name = "Efgbgnghtj";
		e5.userId = "E1314151617";
		e5.age = 33;
		e5.salary = 45000D;
		e5.experience = 6.2;

		e6.name = "Fgh";
		e6.userId = "F151620212223";
		e6.age = 55;
		e6.salary = 80000D;
		e6.experience = 19;

		employees.add(e1);
		employees.add(e2);
		employees.add(e3);
		employees.add(e4);
		employees.add(e5);
		employees.add(e6);

	}

	static class Util {

		public static String reverseName(final Employee emp) {
			String reversedEmpName = "";
			String empName = emp.name;
			for (int i = empName.length() - 1; i >= 0; i--) {
				reversedEmpName += empName.charAt(i);
			}

			return reversedEmpName;
		}
	}

	public static void main(String[] args) {

		ComparatorDemo obj = new ComparatorDemo();
		// ComparatorDemo.Util util = new Util();
		try {
			OUT.println("Showing elements in list using stream");
			// creating a consumer to print the list elements
			Consumer<Employee> showEmpConsumer = (Employee e) -> OUT.println(e);
			// creating supplier for the exception
			Supplier<Exception> excepSupplier = () -> {
				return new RuntimeException();
			};
			Function<String, Integer> nameComparatorFunction = (n1) -> {
				return n1.length();
			};
			Function<Integer, Integer> experienceComparatorFunction = (exp) -> {
				return exp;
			};
			Function<String, Integer> userIdLenghtCompFunction = (userId) -> {
				return userId.length();
			};
			Function<Employee, Double> getEmployeeSalary = (e) -> {
				return e.salary;
			};

			// create a comparator
			Comparator<String> compareByNameLength = Comparator.comparing(nameComparatorFunction);
			Comparator<String> compareByUserIdLength = Comparator.comparing(userIdLenghtCompFunction);
			// create another comparator
			Comparator<Integer> compareByExperience = Comparator.comparing(experienceComparatorFunction);

			/*
			 * This below code is not working as the signatures are different
			 * experienceComparatorFunction.andThen(nameComparatorFunction);
			 * 
			 */
			OUT.println("Showing elements in list using method reference of a consumer");
			obj.employees.stream().forEach(ComparatorDemo::showEmployees); // this takes a consumer static method
																			// reference

			OUT.println("Reversing each Employee Name");
			Stream<String> reversedEmpNameStream = obj.employees.stream().map(ComparatorDemo.Util::reverseName);
			reversedEmpNameStream.forEach(n -> OUT.println(n));

			// do the same thing using optional
			Optional<Stream<String>> rvrsdEmpNameStrmOpt = Optional.ofNullable(Optional
					.of(obj.employees.stream().map(ComparatorDemo.Util::reverseName)).orElseThrow(excepSupplier));

			if (rvrsdEmpNameStrmOpt.isPresent()) {
				// working
				// OUT.println("Showing results in the reversed order");
				// rvrsdEmpNameStrmOpt.get().sorted(Comparator.reverseOrder()).forEach(OUT::println);

				// working
				// OUT.println("Showing results in the sorted order in ascending order of name
				// length");
				// rvrsdEmpNameStrmOpt.get().sorted(compareByNameLength.reversed()).forEach(OUT::println);

				OUT.println("Shwoing result based on name and experince");
				rvrsdEmpNameStrmOpt.get()
						.sorted(compareByNameLength.reversed().thenComparing(compareByUserIdLength.reversed()))
						.forEach(OUT::println);

			}

			// find the maximum salaried emplyee
			Optional<Employee> maxSalaried = obj.employees.stream().sorted((emp1, emp2) -> {
				return Double.compare(emp2.salary, emp1.salary);
			}).findFirst();

			OUT.println("Showing salaries");
			List<Double> salaries = obj.employees.stream()// .filter((e) -> {
					// return e.salary > 0.0D;
					// })
					.map(getEmployeeSalary).collect(Collectors.toList());

			if (salaries instanceof List) {
				OUT.println("List object");
				salaries.forEach(OUT::println);
			}

			Double totalPaidSalary = salaries.stream().reduce(0.0d, (s1, s2) -> s1 + s2);
			OUT.println("Total salary paid : " + totalPaidSalary);

			OUT.println("Max salaried employee: " + maxSalaried.get());

			OUT.println("Count is: " + IntStream.range(1, 11).count());
			OUT.println("Average is: " + IntStream.range(1, 11).average());
			OUT.println("Sum of elements" + IntStream.range(1, 11).reduce(1, (a, b) -> a * b));

			// create a map of employee name and userid
			OUT.println("Creating Map of employee name and userid");
			Map<Object, Object> nameUserIdMap = obj.employees.stream()
					.collect(Collectors.toMap((e) -> e.name, (e) -> e.userId));
			OUT.println("Map is ===> ");
			nameUserIdMap.entrySet().stream()
					.forEach((e) -> OUT.println("Name: " + e.getKey() + " UserID: " + e.getValue()));

			// similarly to sort the map in ascending order
			Map<String, String> sortedNameUserIdMap = obj.employees.stream()
					.sorted((e1, e2) -> Integer.compare(e2.age, e1.age))
					.collect(Collectors.toMap((e) -> e.name, (e) -> e.userId, (k1, v1) -> k1, HashMap::new));

			OUT.println("In the sorted order");
			sortedNameUserIdMap.entrySet().stream()
					.forEach((e) -> OUT.println("Name: " + e.getKey() + " UserID: " + e.getValue()));

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

			OUT.println("Finding distinct elements");
			List<Integer> uniqueNums = nums.stream().distinct().collect(Collectors.toList());
			uniqueNums.stream().forEach(OUT::println);

			// get the average valuesS
			OptionalDouble avg = nums.stream().mapToInt((e) -> e).average();
			OUT.printf("Average is: %.3f\n", avg.getAsDouble());
			OUT.println("Total number of elems: " + nums.stream().count());
			// group by
			OUT.println("Showing groups");
			OUT.println(nums.stream().collect(Collectors.groupingBy((e) -> e)));
			// showing frequencies of elements
			OUT.println("Showing frequesncies");
			OUT.println(nums.stream().collect(Collectors.groupingBy((e) -> e, Collectors.counting())));
			// get the maximum frequency element
			OUT.println("Getting the max frequency element in each group");
			OUT.println(nums.stream().collect(
					Collectors.groupingBy((e) -> e, Collectors.reducing(BinaryOperator.maxBy(Integer::compare))) // end
																													// of
																													// goruping
																													// by
			) // end of collect
			);

			// get the most frequent characters using stream
			OUT.println("Most frequent char");
			String str = "aaaabbcdddeefffff";
			OUT.println(
					str.chars().mapToObj((x) -> (char) x).collect(Collectors.groupingBy(x -> x, Collectors.counting()))
							.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey());

			// Stream<Integer> charStream = Stream.of(1, 2, 3, 4, 5);
			OUT.println(str.chars().distinct().mapToObj((ascii) -> String.valueOf((char) (ascii - 32)))
					.collect(Collectors.toList()).stream().collect(Collectors.joining(",")));
			OUT.println("Get min and max");

			// get the min and maximum value from a Stream
			List<Integer> numbers = Arrays.asList(42, 4, 2, 24);
			Optional<Integer> min = numbers.stream().collect(Collectors.minBy(Integer::compareTo));
			Optional<Integer> max = numbers.stream().collect(Collectors.maxBy(Integer::compareTo));
			// get the min and maximum value from a stream method 2
			OUT.println("Minimum value: " + min.get() + "Maximum value: " + max.get());
			OUT.println("Method 2 : max : " + numbers.stream().max(Integer::compare).get());
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			OUT.close();
		}

	}

	// to demonstrate a method reference
	private static void showEmployees(final Employee e) {
		OUT.println(e);
	}

}
