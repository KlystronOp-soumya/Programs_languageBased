package com.problems;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@FunctionalInterface
interface NumberUtil {

	// this method will only implement basic numberutils e.g. even odd check , leap
	// year , primality etc.
	boolean test(int num);

}

class ComparisonUtil {
	// this method is the method reference for the compare of any comparator
	// this is reference to the compare method
	public static int compareBySalary(Agent o1, Agent o2) {

		return o1.getAgtSalary().compareTo(o2.getAgtSalary());
	}
}

enum Departments {
	// these are objects
	ACCOUNTS("act"), FINANCE("fin"), STOCKS("stk"), TRADES("trd"), NETWORKING("mnet"), MARKETING("mkt"),
	ITINFRA("iinf"), ITAPP("iapp"), ITNETWORKING("inet"), SALES("sls"), HR("mhr");

	public String account_code;

	private Departments() {

	}

	Departments(final String code) {
		this.account_code = code;
	}
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Agent implements Serializable, Comparable<Agent> {

	private static final long serialVersionUID = 1L;

	private String agtId;
	private String agtName;
	private BigDecimal agtSalary;
	private Departments agtDepartment;
	private double experience;
	private char gender;
	// based on name
	/*
	 * @Override
	 * 
	 * public int compareTo(Agent agent) { return
	 * this.getAgtName().compareTo(agent.getAgtName()); }
	 */

	// based on salary
	@Override
	public int compareTo(Agent agent) {
		return (this.getAgtSalary().compareTo(agent.getAgtSalary()));
	}
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class AgentDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String agentName;
	private Departments department;

}

class AgentComparator implements Comparator<Agent> {

	/**
	 * Comparator class to compare the salaries
	 * 
	 */
	@Override
	public int compare(Agent o1, Agent o2) {

		return o1.getAgtSalary().compareTo(o2.getAgtSalary());
	}

}

class AgentExprComparator implements Comparator<Agent> {

	@Override
	public int compare(Agent o1, Agent o2) {

		return Double.compare(o1.getExperience(), o2.getExperience());
	}

}

// a class which replicates the compare method

class FooComparator {
	/**
	 * @author Soumyadeep
	 * @category own implementation
	 * @param Agent object1
	 * @param Agent object2
	 * 
	 * @return int -1,1 or 0
	 */
	public static int fooCompare(Agent a1, Agent a2) {
		// this sorts in descending order
		// to sort in ascending order change the greater than signs
		if (a1.getExperience() > a2.getExperience())
			return -1;
		else if (a1.getExperience() < a2.getExperience())
			return 1;
		else
			return 0;
	}
}

public class StreamApiDemo {

	private static List<Agent> agents;

	static {

		agents = getData();
	}

	private static void print(Object obj) {
		System.out.println(((Optional<Integer>) obj).get());
	}

	public static void main(String[] args) {
		// List<Agent> agents = getData();
		showSecondHighestElem();
		// convertMapToList();
		// sortAgentsOnExprUsual();
		// sortAgentsOnExprMthdRef();
		// showRepeatingElems();
		// sorting(agents);
		// streamAndOptional(agents);
		// bubbleSort();
		// predicateDemo();

	}

	private static void sortAgentsOnExprUsual() {

		agents.stream().forEach(System.out::println);
		AgentExprComparator agentComparator = new AgentExprComparator();
		// usually we will sort a collection using
		Collections.sort(agents, agentComparator); // the second argument takes a comparator
		System.out.println("After sorting");
		agents.stream().forEach(System.out::println);

	}

	private static void sortAgentsOnExprMthdRef() {
		// the similar thing can be achieved using the method reference
		// as Comparator is a functional interface in Java

		agents.stream().forEach(System.out::println);
		System.out.println("After sorting");
		Collections.sort(agents, FooComparator::fooCompare);

		agents.stream().forEach(System.out::println);
	}

	private static void generateIntList() {
		IntSupplier getInt = () -> new Random().nextInt(100); // abstract method is getAsInt
		List<Integer> randomIntegers = IntStream.generate(getInt).boxed().collect(ArrayList::new, ArrayList::add,
				ArrayList::addAll);

		randomIntegers.stream().forEach(System.out::println);
	}

	private static void predicateDemo() {
		Predicate<Integer> somePostiveCondition = (n) -> n > 0;
		Predicate<Integer> checkEven = (n) -> n % 2 == 0;
		Predicate<Integer> checkLeap = (n) -> n % 100 == 0;
		assert somePostiveCondition.test(5) : "This is not greater than 0 ";

	}

	// implements the binary search algorithm
	private static void bubbleSort() {
		Supplier<Integer> randomNumSupplier = () -> new Random().nextInt(10, 20);
		List<Integer> numList = IntStream.rangeClosed(0, 9).map((i) -> i * randomNumSupplier.get())
				.collect(ArrayList::new, ArrayList::add, ArrayList::addAll); // generates random list

		numList.forEach(System.out::println);
	}

	private static void streamAndOptional(List<Agent> agents) {
		List<Integer> numList = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
		List<String> vowels = List.of("a", "e", "i", "o", "u", "A", "E", "I", "O", "U");
		// min takes a Comparator since we have used Wrapper class then
		// provide a default one's method reference
		print(numList.stream().min(Integer::compare));
		// otherwise we can provide an implementation
		print(numList.stream().max((Integer x, Integer y) -> Integer.compare(x, y)));

		// get the minimum salary of agent
		Comparator<Agent> compareAgentsBySalary = Comparator.comparing((Agent agt) -> agt.getAgtSalary());
		// agents.clear();
		Optional<Agent> minSalOptional = agents.stream().min(compareAgentsBySalary);

		Predicate<Agent> salaryFilter = (Agent agt) -> agt.getAgtSalary().compareTo(new BigDecimal("55000")) > 0;
		// create a map of Agent Name and salary
		// merge function and the supplier function is not required as not chance of
		// conflict
		Map<String, BigDecimal> agentSalaryMap = agents.stream().filter(salaryFilter)
				.collect(Collectors.toMap(Agent::getAgtName, Agent::getAgtSalary));

		// display the entries
		agentSalaryMap.entrySet().stream().forEach((elem) -> System.out.println(elem.getKey() + ":" + elem.getValue()));

		System.out.println("------------------Sorted Map-------------------");
		// now sort this map
		agentSalaryMap.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.forEach((elem) -> System.out.println(elem.getKey() + ":" + elem.getValue()));

		// now get the max value
		Optional<Entry<String, BigDecimal>> agent = agentSalaryMap.entrySet().stream()
				.max(Map.Entry.comparingByValue());

		System.out.println("Max value:");
		if (agent.isPresent()) {
			System.out.println(agent.get().getKey() + ":" + agent.get().getValue());
		}

		// Convert the names to upper case
		Function<Agent, Agent> toUpperCaseName = (a) -> {
			a.setAgtName(a.getAgtName().toUpperCase());
			return a;
		};
		// convert the names to upper case only
		Function<Agent, String> toUpperCaseOnlyName = (a) -> a.getAgtName().toUpperCase();
		// we need to convert it into the list as map is an intermediate operation it
		// only converts the elements and doesnt return any stream
		agents.stream().map(toUpperCaseName).toList().forEach(System.out::println);
		agents.stream().map(toUpperCaseOnlyName).toList().forEach(System.out::println);

		String str = "Cauliflower";
		System.out.println("#of vowels:" + str.chars().filter((e) -> "aeiouAEIOU".indexOf(e) != -1).count());

		// group by deparment -- takes a function
		Map<Object, List<Agent>> agMap = agents.stream()
				.collect(Collectors.groupingBy((eachAgent) -> eachAgent.getAgtDepartment()));

		agMap.entrySet().stream().forEach((o) -> System.out.println(o.getKey() + " : " + o.getValue()));

		// group by department -- take the names only
		System.out.println("----------------- Group By Department and Name -------------------------");
		Map<Departments, List<String>> departAgtNameMap = agents.stream().collect(Collectors
				.groupingBy(Agent::getAgtDepartment, Collectors.mapping(Agent::getAgtName, Collectors.toList())));
		// similar to above just used lambda expression
		Map<Departments, List<String>> departAgtNameMap2 = agents.stream().collect(Collectors.groupingBy(
				Agent::getAgtDepartment, Collectors.mapping((agt) -> agt.getAgtName(), Collectors.toList())));
		departAgtNameMap.entrySet()
				.forEach((eachEntry) -> System.out.println(eachEntry.getKey() + ":" + eachEntry.getValue()));

		Comparator<Agent> byExperince = Comparator.comparing(Agent::getExperience);
		// get the most experienced people from each group -- first argument is the
		// classifier the second one is binaryOperator
		Function<Agent, Departments> departmentClassifier = (agt) -> agt.getAgtDepartment();
		Map<Departments, Optional<Agent>> mostExprncdAgtMap = agents.stream().collect(
				Collectors.groupingBy(departmentClassifier, Collectors.reducing(BinaryOperator.maxBy(byExperince))));
		System.out.println("----------------- Showing most experienced in each group---------------------------------");
		mostExprncdAgtMap.entrySet().forEach((e) -> System.out.println(e.getKey() + ":" + e.getValue()));
		// get the average salary in each group
		System.out
				.println("------------------------ Dept With Average Salary ----------------------------------------");
		Map<Departments, Double> deptWithAverageSalary = agents.stream().collect(Collectors.groupingBy(
				departmentClassifier, Collectors.averagingDouble((agt) -> agt.getAgtSalary().doubleValue())));

		deptWithAverageSalary.entrySet().forEach(
				(eachElemInMap) -> System.out.println(eachElemInMap.getKey() + ":" + eachElemInMap.getValue()));

		Function<Map.Entry<Departments, List<String>>, List<String>> agentNameFromMap_Mapper = (eachAgent) -> eachAgent
				.getValue();
		// get the names from the map --flat the map entries
		List<String> nameLists = departAgtNameMap.entrySet().stream().flatMap(a -> a.getValue().stream())
				.collect(Collectors.toList());

		// join the names with comma
		String names = nameLists.stream().collect(Collectors.joining(","));

		System.out.println("Names: " + names);

		System.out.println("Frequency of chars in Stting");
		Stream<String> str2 = Stream.of("aabbccccddd");
		Function<String, String> function = s -> s; // classifier for grouping
		Map<String, Long> charFreq = str2.collect(Collectors.groupingBy(function, Collectors.counting()));

		charFreq.entrySet().forEach(
				(eachElemInMap) -> System.out.println(eachElemInMap.getKey() + ":" + eachElemInMap.getValue()));

		// frequency of the characters in a String using Function.identity
		String input = "aasjjikkk";
		Map<Character, Long> frequency = input.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		frequency.entrySet().forEach(
				(eachElemInMap) -> System.out.println(eachElemInMap.getKey() + ":" + eachElemInMap.getValue()));

		// String to list of chars
		input.chars().mapToObj(ch -> (char) ch).collect(Collectors.toList());
	}

	/**
	 * 
	 * 
	 * @param List<Agent> agents
	 * @return void
	 * 
	 * 
	 */
	private static void sorting(final List<Agent> agents) {
		// Defining a consumer -- just accepts the argument and does not return any row
		Consumer<Agent> showAgentName = (Agent agent) -> System.out.println(agent.getAgtName());
		Consumer<Agent> showAgentNameWithSalary = (Agent agent) -> System.out
				.println(agent.getAgtName() + "->" + agent.getAgtSalary());
		Consumer<Agent> showAgentNameWithExp = (Agent agt) -> System.out
				.println(agt.getAgtName() + "->" + agt.getExperience());
		// compare the names and sort them in Ascending dictionary order
		System.out.println("Agents before sorting");
		agents.stream().forEach(showAgentName); // this takes a consumer
		System.out.println("Agents after sorting");
		// Arrays.sort(agents.toArray()); // this used the compareTo method to sort the
		// names
		// agents.stream().forEach(showAgentName);
		// Now the change the comapreTo to compare based on the salary
		Arrays.sort(agents.toArray()); // this used the compareTo method to sort the salary
		// agents.stream().forEach(showAgentNameWithSalary);

		// compare using the comparator
		AgentComparator compareBySalary = new AgentComparator();
		Collections.sort(agents, compareBySalary);
		agents.stream().forEach(showAgentNameWithSalary);
		// compare by salary using Lambda function
		Collections.sort(agents, (a1, a2) -> a1.getAgtName().compareTo(a2.getAgtName()));
		agents.stream().forEach(showAgentNameWithSalary);
		System.out.println("Sorting using the method referrence");
		Collections.sort(agents, ComparisonUtil::compareBySalary);
		agents.stream().forEach(showAgentNameWithSalary);

		// sort using the comaparators
		// defining a Function
		ToDoubleFunction<Agent> agtExpDoubleFunction = (Agent agt) -> agt.getExperience();
		Comparator<Agent> compareByExperience = Comparator.comparingDouble(agtExpDoubleFunction);
		// the Function extracts the keyfield -- we can use method reference
		System.out.println("--------------Sorted by Name:[REF]------------------");
		Comparator<Agent> compareByNameRef = Comparator.comparing(Agent::getAgtName);
		Collections.sort(agents, compareByNameRef);
		agents.stream().forEach(showAgentName);
		System.out.println("--------------Sorted by Name:[LAM]------------------");
		Comparator<Agent> compareByNameLam = Comparator.comparing((Agent agt) -> agt.getAgtName());
		Collections.sort(agents, compareByNameLam);
		agents.stream().forEach(showAgentName);
		System.out.println("-------------Sorted by exp:---------------------------");
		Collections.sort(agents, compareByExperience);
		agents.stream().forEach(showAgentNameWithExp);
		System.out.println("-------------Sorted by exp:---------------------------");
		agents.stream().sorted((Agent a1, Agent a2) -> Double.compare(a1.getExperience(), a2.getExperience()))
				.forEach(showAgentNameWithExp);
		// now to sort the agents descending order -- just reverse the comparator
		System.out.println("--------------Sorted by exp:[DESC]------------------");
		Collections.sort(agents, compareByExperience.reversed());
		agents.stream().forEach(showAgentNameWithExp);
		// we can also chain the comparators as
		Collections.sort(agents, compareByNameLam.thenComparing(compareByExperience));
	}

	private static List<Agent> getData() {
		List<Agent> agents = new ArrayList<>();
		// Create 10 Agent objects
		Agent agent1 = new Agent("ID1", "John Doe", new BigDecimal("50000"), Departments.SALES, 1.5, 'M');
		Agent agent2 = new Agent("ID2", "Alice Smith", new BigDecimal("60000"), Departments.MARKETING, 3.6, 'F');
		Agent agent3 = new Agent("ID3", "Bob Johnson", new BigDecimal("55000"), Departments.HR, 10.2, 'O');
		Agent agent4 = new Agent("ID4", "Eva Brown", new BigDecimal("58000"), Departments.ITAPP, 5.3, 'F');
		Agent agent5 = new Agent("ID5", "Michael Lee", new BigDecimal("52000"), Departments.SALES, 0.3, 'M');
		Agent agent6 = new Agent("ID6", "Sophia Adams", new BigDecimal("62000"), Departments.MARKETING, 4.2, 'F');
		Agent agent7 = new Agent("ID7", "David Clark", new BigDecimal("54000"), Departments.HR, 8.9, 'M');
		Agent agent8 = new Agent("ID8", "Olivia White", new BigDecimal("57000"), Departments.ITNETWORKING, 6.2, 'F');
		Agent agent9 = new Agent("ID9", "William Green", new BigDecimal("53000"), Departments.SALES, 11, 'M');
		Agent agent10 = new Agent("ID10", "Emma Turner", new BigDecimal("61000"), Departments.MARKETING, 13.0, 'O');

		agents.add(agent1);
		agents.add(agent2);
		agents.add(agent3);
		agents.add(agent4);
		agents.add(agent5);
		agents.add(agent6);
		agents.add(agent7);
		agents.add(agent8);
		agents.add(agent9);
		agents.add(agent10);

		return agents;
	}

	/*
	 * The below methods are mostly asked questions interviews
	 * 
	 */

	static void showRepeatingElems() {

		// display only the repeating elements in string
		String str = "bbacbcdeef";
		// As streams implements Functional programming paradigm hence always write down
		// what do not and not how to do
		// convert the string to stream
		// then create a map with the #Occurences by grouping by with count
		// filter out those entries which has #Occur > 1
		// store these elements in a list

		Stream<Character> charStream = str.chars().mapToObj(eachAscii -> (char) eachAscii);
		// supplier , BiConsumer accumulator , BiConsumer combiner
		Function<Character, Character> getKeyFunction = ch -> ch;
		Predicate<Entry<Character, Integer>> countMoreThnOne = (pair) -> pair.getValue() > 1;

		List<Character> freq = charStream.collect(Collectors.groupingBy(getKeyFunction, Collectors.counting()))
				.entrySet().stream().filter(p -> p.getValue() > 1).map(p -> p.getKey()).collect(Collectors.toList());

		// charStream.forEach(System.out::println);

	}

	static void showRepeatingElemsAsMap() {

	}

	static void showNthRecordInMap() {

	}

	static void convertMapToList() {
		// convert a map to list using stream api
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "One");
		map.put(2, "Two");
		map.put(3, "Three");

		List<Map.Entry<Integer, String>> entryList = map.entrySet().stream().collect(Collectors.toList());
		List<Integer> keys = map.keySet().stream().toList();
		List<String> valuesList = map.values().stream().toList();

		// create a map first
		Map<String, Agent> agentMap = new HashMap<>();
		Function<Agent, String> keyMapper = (agent) -> agent.getAgtId();
		Function<Agent, Agent> valueMapper = (agent) -> agent;
		// create a map of agent id and whole object
		agentMap = agents.stream().collect(Collectors.toMap(Agent::getAgtId, (eachAgent) -> eachAgent));

		agentMap.entrySet().forEach(
				(eachElemInMap) -> System.out.println(eachElemInMap.getKey() + ":" + eachElemInMap.getValue()));

	}

	static void showFirstNonRepeatingChar() {

	}

	static void showSecondHighestElem() {// it should be implemented using MaxHeap in O(n) without sorting

		Supplier<Integer> randomNumSupplier = () -> new Random().nextInt(10, 20);
		List<Integer> numList = IntStream.rangeClosed(0, 9).map((i) -> i * randomNumSupplier.get())
				.collect(ArrayList::new, ArrayList::add, ArrayList::addAll); // generates random list

		numList.stream().forEach(System.out::println);

		Optional<Integer> secondHigh = numList.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst();
		System.out.println("Second largest: " + secondHigh.orElse(Integer.MAX_VALUE));

		// now lets use the priorityQueue
		PriorityQueue<Integer> pq = numList.stream().collect(PriorityQueue::new, PriorityQueue::add,
				PriorityQueue::addAll);
		pq.remove();
		int secHigh = pq.remove();
		System.out.println("Second high in PQ: " + secHigh); // this would result in the second lowest value as this is
																// a MaxHeap
		// we need to convert it into the MinHeap
		PriorityQueue<Integer> pqMin = numList.stream().collect(() -> new PriorityQueue(Comparator.reverseOrder()),
				PriorityQueue::add, PriorityQueue::addAll);
		pqMin.remove();
		System.out.println("Now the second highest: " + pqMin.poll());

	}

	static void showFirstRepeatingChar() {

	}

	static void checkAnagram() {

	}
}
