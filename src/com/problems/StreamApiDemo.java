package com.problems;

import static java.util.stream.Collectors.filtering;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
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
	private int age;
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
		// sortAgentByExprAndSalary();
		// sortAgentsOnExprStream();
		// generateIntList();
		// showFirstRepeatingChar();
		// showLongestName();
		// showFirstNonRepeatingChar();
		// mapToListDemo();
		// showSecondHighestElem();
		// convertMapToList();
		// sortAgentsOnExprUsual();
		// sortAgentsOnExprMthdRef();
		// showRepeatingElems();
		// sorting(agents);
		// streamAndOptional(agents);
		// bubbleSort();
		// predicateDemo();

		// getIntStreamFromList();
		// showNthRecordInMap();
		// intstreamAndComparator();
		// checkAnagram();
		// findMissingElementInArray();
		tokenizeString();
		makeRequestURL();
		stringTask();
		generateFibonacciSeq();
		changeCaseStrings();
		streamIteratorDemo();
	}

	private static void intstreamAndComparator() {
		// get the int stream
		Random random = new Random();
		List<Integer> nums = IntStream.generate(() -> random.nextInt(65, 90)).boxed().limit(10).toList();
		System.out.println("Generated: " + nums);
		// sort the nums
		// nums = nums.stream().sorted(Integer::compare).toList(); // comparator is
		// defined
		// nums = nums.stream().sorted((a, b) -> Integer.compare(a, b)).toList(); //
		// Lambda is used
		// nums = nums.stream().sorted(Comparator.reverseOrder()).toList(); // reversed
		nums = nums.stream().sorted(Comparator.naturalOrder()).toList(); // uses the natural ascending order
		System.out.println("Sorted: " + nums);

		// filter the elements
		int maxElement = nums.stream().max(Comparator.naturalOrder()).get();
		System.out.println("Max element: " + maxElement);
		int minElement = nums.stream().min(Comparator.naturalOrder()).get();
		System.out.println("Min element: " + minElement);

		// Get the average
		Double avg = IntStream.rangeClosed(5, 25).average().getAsDouble();
		System.out.println("Average value: " + avg.doubleValue());

		// Get the statistics
		IntSummaryStatistics statistics = nums.stream().mapToInt(i -> Integer.valueOf(i)).summaryStatistics();
		System.out.println("Stats are:\naverage: " + statistics.getAverage() + "\nsum:" + statistics.getSum());
		// convert the list to Map
		Map<Object, Long> freqMap = nums.stream().collect(Collectors.groupingBy(i -> i, Collectors.counting()));
		System.out.println(freqMap);
		// there is another overloading -- since tree map hence in the sorted order of
		// keys
		Map<Object, Long> treeFreqMap = nums.stream().collect(
				Collectors.groupingBy(Integer::valueOf, () -> new TreeMap<Object, Long>(), Collectors.counting()));
		System.out.println(treeFreqMap);

		// intstream generates values within ASCII value set
		// hence the output is alphabet vs freq
		Map<String, Integer> nameMap = nums.stream()
				.collect(Collectors.toMap((i) -> String.valueOf((char) i.intValue()), Integer::valueOf, (a, b) -> b));

		System.out.println(nameMap);

		// get the ascii map in sorted order
		Map<String, Integer> asciiMapSorted = nums.stream().collect(Collectors.toMap(
				(i) -> String.valueOf((char) i.intValue()), Integer::valueOf, (a, b) -> b, () -> new TreeMap<>()));

		System.out.println("ASCII Map: " + asciiMapSorted);

		// create List to Map using groupingby the frequency
		Map<Object, Long> treeAsciiFreqMap = nums.stream().collect(Collectors.groupingBy(
				i -> String.valueOf((char) i.intValue()), () -> new TreeMap<Object, Long>(), Collectors.counting()));
		System.out.println(treeAsciiFreqMap);

		// get the elements with the max freq
		Set<Object> repeatedChars = treeAsciiFreqMap.entrySet().stream().filter(p -> p.getValue() > 1)
				.map(p -> p.getKey()).collect(Collectors.toSet());

		System.out.println(repeatedChars);

		// create a map of Department vs Agents
		Map<Departments, List<Agent>> deptAgentMap = new HashMap<Departments, List<Agent>>();
		deptAgentMap.put(Departments.SALES,
				List.of(new Agent("ID32", "John Michael", new BigDecimal(60000D), Departments.SALES, 2.5, 'M', 30),
						new Agent("ID1", "John Doe", new BigDecimal("53000"), Departments.SALES, 1.5, 'M', 25),
						new Agent("ID5", "Michael Lee", new BigDecimal("52000"), Departments.SALES, 0.3, 'M', 24),
						new Agent("ID9", "William Green", new BigDecimal("53000"), Departments.SALES, 11, 'M', 36)));

		deptAgentMap.put(Departments.MARKETING, List.of(
				new Agent("ID6", "Sophia Adams", new BigDecimal("62000"), Departments.MARKETING, 4.2, 'F', 27),
				new Agent("ID2", "Alice Smith", new BigDecimal("60000"), Departments.MARKETING, 3.6, 'F', 29),
				new Agent("ID10", "Emma Turner", new BigDecimal("61000"), Departments.MARKETING, 13.0, 'O', 39)));

		// get a flat map
		List<Agent> agents = deptAgentMap.values().stream().flatMap(l -> l.stream()).toList();
		System.out.println(agents);

		// create a map grouping by the depts
		Map<Object, List<Agent>> deptAgentMap2 = agents.stream().collect(Collectors
				.groupingBy((agt) -> agt.getAgtDepartment(), Collectors.mapping((Agent a) -> a, Collectors.toList())));

		System.out.println(deptAgentMap2);
		// create a map grouping by the dept with Agent name only
		Map<Object, List<String>> deptAgentNameMap = agents.stream().collect(Collectors.groupingBy(
				(agt) -> agt.getAgtDepartment(), Collectors.mapping(Agent::getAgtName, Collectors.toList())));

		System.out.println(deptAgentNameMap);

		// now get the agent who draws maximum salary in each dept
		Map<Departments, Optional<Agent>> maxedSalariedInDeptsOpt = deptAgentMap2.values().stream()
				.flatMap(l -> l.stream()).collect(Collectors.groupingBy(Agent::getAgtDepartment,

						Collectors.maxBy(Comparator.comparing(Agent::getAgtSalary))));

		System.out.println(maxedSalariedInDeptsOpt);

		// gets Agent names with Maximum salaries in each department
		Map<Departments, String> maxedSalariedInDept = deptAgentMap2.values().stream().flatMap(l -> l.stream())
				.collect(Collectors.groupingBy(Agent::getAgtDepartment, Collectors.collectingAndThen(
						Collectors.maxBy(Comparator.comparing(Agent::getAgtSalary)), (p) -> p.get().getAgtName())));

		System.out.println(maxedSalariedInDept);

		// gets the Agent details with Maximum salary in Each department
		Map<Departments, Agent> maxedSalariedInDept2 = deptAgentMap2.values().stream().flatMap(l -> l.stream())
				.collect(Collectors.groupingBy(Agent::getAgtDepartment, Collectors.collectingAndThen(
						Collectors.maxBy(Comparator.comparing(Agent::getAgtSalary)), (p) -> p.get())));

		System.out.println(maxedSalariedInDept2);

		// get the agent is each department whose salary is greater than 60k
		Function<Agent, Departments> agentToDeptClassifier = (Agent a) -> a.getAgtDepartment();
		Predicate<Agent> salaryCheck = (Agent t) -> t.getAgtSalary().compareTo(new BigDecimal(60000D)) > 0;
		Map<Departments, List<Agent>> higherSalariedInDeptMap = deptAgentMap2.values().stream().flatMap(l -> l.stream())
				.collect(groupingBy(agentToDeptClassifier, filtering(salaryCheck, toList())));

		System.out.println(higherSalariedInDeptMap);

		// get the agent is each department whose salary is greater than 60k removing
		// the blank sales team
		Map<Departments, List<Agent>> higherSalariedInDeptMapNonBlank = deptAgentMap2.values().stream()
				.flatMap(List::stream)
				.collect(Collectors.groupingBy(agentToDeptClassifier,
						Collectors.filtering(salaryCheck, Collectors.toList())))
				.entrySet().stream().filter(entry -> !entry.getValue().isEmpty()) // Remove empty lists
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		System.out.println(higherSalariedInDeptMapNonBlank);

		// create a map of Agent name vs Dept
		List<Agent> agents2 = getData();

		Map<Agent, Departments> agentDeptMap = agents2.stream()
				.collect(Collectors.toMap(Function.identity(), t -> t.getAgtDepartment()));

		System.out.println(agentDeptMap);

		// sort the entries based on the Agent salary --need to check
		Function<Entry<Agent, Departments>, BigDecimal> extractSalary = entry -> entry.getKey().getAgtSalary();
		Comparator<Entry<Agent, Departments>> compareBySalary = (a, b) -> a.getKey().getAgtSalary()
				.compareTo(b.getKey().getAgtSalary());
		// nameDeptMap.entrySet().stream().sorted(compareBySalary.reversed());
		Map<String, Departments> nameDeptMap = agents2.stream()
				.collect(Collectors.toMap((agt) -> agt.getAgtName(), t -> t.getAgtDepartment()));

		System.out.println(nameDeptMap);

		// sort the map based on longest name

	}

	private static List<Agent> getData() {
		List<Agent> agents = new ArrayList<>();
		// Create 10 Agent objects
		Agent agent1 = new Agent("ID1", "John Doe", new BigDecimal("50000"), Departments.SALES, 1.5, 'M', 25);
		Agent agent2 = new Agent("ID2", "Alice Smith", new BigDecimal("60000"), Departments.MARKETING, 3.6, 'F', 29);
		Agent agent3 = new Agent("ID3", "Bob Johnson", new BigDecimal("55000"), Departments.HR, 10.2, 'O', 34);
		Agent agent4 = new Agent("ID4", "Eva Brown", new BigDecimal("58000"), Departments.ITAPP, 5.3, 'F', 30);
		Agent agent5 = new Agent("ID5", "Michael Lee", new BigDecimal("52000"), Departments.SALES, 0.3, 'M', 24);
		Agent agent6 = new Agent("ID6", "Sophia Adams", new BigDecimal("62000"), Departments.MARKETING, 4.2, 'F', 27);
		Agent agent7 = new Agent("ID7", "David Clark", new BigDecimal("54000"), Departments.HR, 8.9, 'M', 28);
		Agent agent8 = new Agent("ID8", "Olivia White", new BigDecimal("57000"), Departments.ITNETWORKING, 6.2, 'F',
				27);
		Agent agent9 = new Agent("ID9", "William Green", new BigDecimal("53000"), Departments.SALES, 11, 'M', 36);
		Agent agent10 = new Agent("ID10", "Emma TurnerGreenGreen", new BigDecimal("61000"), Departments.MARKETING, 13.0,
				'O', 39);

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

		// get the characters which are having occurrence more than 1
		List<Character> freq = charStream.collect(Collectors.groupingBy(getKeyFunction, Collectors.counting()))
				.entrySet().stream().filter(p -> p.getValue() > 1).map(p -> p.getKey()).collect(Collectors.toList());

		// charStream.forEach(System.out::println);

	}

	static void showRepeatingElemsAsMap() {
		// get the stream from the string
		// Collect the stream with grouping
		// return as map
		String str = "apple";
		Map<String, Long> freqMap = List.of(str).stream()
				.collect(Collectors.groupingBy(eachChar -> eachChar, Collectors.counting()));

	}

	static void showNthRecordInMap() {

		// show the Nth record in a Map
		// create a map from the available data
		Map<String, Integer> agentNameAgeMap = agents.stream()
				.collect(Collectors.toMap((eachAgent) -> eachAgent.getAgtName(), (eachAgent) -> eachAgent.getAge()));

		Optional<Entry<String, Integer>> opt = agentNameAgeMap.entrySet().stream().skip(2).findFirst();

		System.out.println(opt.get().getKey() + " : " + opt.get().getValue());
	}

	// demo on the flatmap
	static void flatMapDemo() {
		List<List<Integer>> listOfLists = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5),
				Arrays.asList(6, 7, 8));

		int sum = listOfLists.stream().flatMap(eachList -> eachList.stream()).mapToInt(Integer::intValue).sum();
	}

	static void intStreamDemo() {
		Supplier<Integer> randomNumSupplier = () -> new Random().nextInt(10, 20);
		List<Integer> numList = IntStream.rangeClosed(0, 9).map((i) -> i * randomNumSupplier.get())
				.collect(ArrayList::new, ArrayList::add, ArrayList::addAll); // generates random list

		// convert a List to intStream
		ToIntFunction<Integer> mapToInteger = (Integer i) -> i.intValue();
		IntStream intStream = numList.stream().mapToInt(mapToInteger);

		IntSummaryStatistics summaryIntStream = intStream.summaryStatistics();

		System.out.println(summaryIntStream.getAverage());
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

		String str = "abdabcd";
		// complexity O(n) space O(n)
		// convert the string to a map of char freq
		// then get the char which has the freq= 1

		Function<Character, String> classifierStr = (Character c) -> String.valueOf(c);

		// need to convert the intStream to char first
		// then classify the characters to string and collect using the counting
		// this will return a Map of Str:Int

		Map<String, Integer> freqMap = str.chars().mapToObj(e -> (char) e)
				.collect(Collectors.groupingBy(classifierStr, Collectors.summingInt(e -> 1)));

		// print the map
		freqMap.entrySet().forEach(
				(eachElemInMap) -> System.out.println(eachElemInMap.getKey() + ":" + eachElemInMap.getValue()));

		// now get the entry / character which has the freq = 1
		// till the findFirst is returns Entry
		// then map it to getKey
		Optional<?> opt = freqMap.entrySet().stream().filter((pair) -> pair.getValue() == 1).findFirst()
				.map((entry) -> entry.getKey());

		System.out.println(opt.get());

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
		PriorityQueue<Integer> pqMin = numList.stream().collect(
				() -> new PriorityQueue<Integer>(Comparator.reverseOrder()), PriorityQueue::add, PriorityQueue::addAll);
		pqMin.remove();
		System.out.println("Now the second highest: " + pqMin.poll());

	}

	static void showFirstRepeatingChar() {

		String str = "addacecb";

		String firstRepeatingChar = str.chars().mapToObj(ch -> (char) ch)
				.collect(Collectors.groupingBy(ch -> String.valueOf(ch), Collectors.summingInt(n -> 1))).entrySet()
				.stream().filter((pair) -> pair.getValue() == 2).findFirst().get().getKey();

		System.out.println("First repeating character: " + firstRepeatingChar);

	}

	static void checkAnagram() {
		String str1 = null, str2 = null;
		if (str1.length() != str2.length()) {
			// false; // Different lengths can't be anagrams
		}

		// Sort characters using Stream API
		String sortedStr1 = Stream.of(str1.split("")).sorted().collect(Collectors.joining());

		String sortedStr2 = Stream.of(str2.split("")).sorted().collect(Collectors.joining());

		sortedStr1.equals(sortedStr2);

	}

	static void summingCollectors() {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		Integer sum = numbers.stream().collect(Collectors.summingInt(Integer::intValue));
		System.out.println("Sum: " + sum);

	}

	// collectingAndThen Demo
	public static void collectingAndThenDemo() {
		// get the longest name of the Agents
		String longestNames = agents.stream().collect(
				Collectors.collectingAndThen(Collectors.mapping(Agent::getAgtName, Collectors.toList()), nameList -> {
					return nameList.stream().collect(Collectors.maxBy(Comparator.comparing(String::length)))
							.orElse("?");

				}));

		// the same can be achieved using the reduction function

	}

	public static void showLongestName() {
		// first get the list of the names
		List<String> agentNames = agents.stream()
				.collect(Collectors.mapping((eachObj) -> eachObj.getAgtName(), Collectors.toUnmodifiableList()));

		List<String> agentNames2 = agents.stream().map(Agent::getAgtName).toList();

		// show the lists to check if they are same

		// then reduce
		BinaryOperator<String> accumulateNames = (str1, str2) -> str1.length() > str2.length() ? str1 : str2;
		String logestName = agentNames.stream().reduce(accumulateNames).orElse("?");

		String lonString = agents.stream()
				.collect(Collectors.reducing("Undefined", Agent::getAgtName, accumulateNames));

		// otherwise we can use sort
		Comparator<String> nameComparator = Comparator.comparing(String::length);
		String longestName2 = agents.stream().map(Agent::getAgtName).sorted(nameComparator.reversed()).findFirst()
				.orElse("?");

		System.out.println("Longest name using reduce: " + logestName + "\n using reducing: " + lonString
				+ "\n using sorting: " + longestName2);
	}

	/*
	 * The below question where asked in Infy interview F2F
	 * 
	 * 1. Given a sentence get the words with freq > 1 2. From a Query params map
	 * form the whole request URL 3. Get the missing element from an array
	 * 
	 */

	static void findMissingElementInArray() {
		int[] ar = { 2, 1, 4, 6, 5 }; // 3 is missing
		ar = Arrays.stream(ar).sorted().toArray();
		int x = 1;
		for (Integer i : ar) {
			if ((x ^ i) != 0) {
				System.out.println("Missing: " + x);
				break;
			}

			x++;
		}

	}

	/*
	 * Actual approach
	 */
	public static void MissingElementFinder() {
		int[] numbers = { 1, 2, 3, 5 }; // Missing 4

		int n = 5; // Maximum number in the sequence
		int missingNumber = IntStream.rangeClosed(1, n).sum() - IntStream.of(numbers).sum();

		System.out.println("Missing number: " + missingNumber);
	}

	/*
	 * Tokenize a sentence and find frequency of each word
	 * 
	 */
	static void tokenizeString() {
		final String str = "a b a c a d e f";

		Map<String, Long> freq = Arrays.asList(str.split(" ")).stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		System.out.println(freq);

	}

	/*
	 * Create a URL from a base URL and add request params
	 * 
	 */
	static void makeRequestURL() {

		StringBuffer stringBuffer = new StringBuffer("http://myacademia.edu.in");
		Map<String, String> queryParamsMap = new LinkedHashMap<>();
		queryParamsMap.put("Id", "123");
		queryParamsMap.put("Name", "ABC");
		queryParamsMap.put("Type", "Uni");

		// baseUrl?Id=123&Name=ABC&Type=Uni

		// The below code wont gurantee the insertion order of the HashMap as stream
		// doesnot maintain the order
		// Use LinkedHashMap to maintain the order

		List<String> qList = queryParamsMap.entrySet().stream().map(ep -> ep.getKey() + "=" + ep.getValue()).toList();
		String queryParams = queryParamsMap.entrySet().stream().map(ep -> ep.getKey() + "=" + ep.getValue())
				.collect(Collectors.joining("&"));
		String queryParams2 = queryParamsMap.entrySet().stream().map(ep -> ep.getKey() + "=" + ep.getValue())
				.collect(Collectors.collectingAndThen(Collectors.joining("&"), s -> s.trim()));
		System.out.println("queryParams: " + queryParams2);
		System.out.println("Request URL: " + stringBuffer + "?" + queryParams2);

	}
	/*
	 * Codeforces problem -- String task replaces the vowels adds '.' before each
	 * consonant without quotes change the case of the uppercase consonant to the
	 * lower case
	 * 
	 */

	public static void stringTask() {

		// replace vowels -> add . before eache consonant -> change the Upper case
		// consonant to lower case
		Predicate<Character> checkVowel = (c) -> !"aeiouy".contains(String.valueOf(c).toLowerCase());
		Function<Character, String> changeCase = (Character c) -> (c >= 65 && c <= 97) ? String.valueOf(c).toLowerCase()
				: String.valueOf(c);
		String str = "abcdYweXiG";
		String res = str.chars().mapToObj(c -> (char) c).filter(checkVowel).map(changeCase)
				.collect(Collectors.collectingAndThen(Collectors.joining("."), s -> ".".concat(s)));
		String res2 = ".";
		res2 += str.chars().mapToObj(c -> (char) c).filter(checkVowel).map(changeCase).collect(Collectors.joining("."));

		System.out.println(res);
		System.out.println(res2);

		assert res.equals(res2);

	}

	/*
	 * Method to generate Fibonacci Sequence using Stream
	 * 
	 */
	public static void generateFibonacciSeq() {

		/*
		 * List<Integer> fibSequence = Stream.iterate(new int[] { 0, 1 }, f -> new int[]
		 * { f[0], f[0] + f[1] }).limit(10) .map(f -> f[0]).toList();
		 * fibSequence.forEach(System.out::println);
		 */

		IntSupplier fibSupplier = new IntSupplier() {
			private int previous = 0, current = 1;

			@Override
			public int getAsInt() {
				int next = previous;
				previous = current;
				current = next + current;
				return next;
			}
		};

		IntStream.generate(fibSupplier).limit(10) // Generate first 10 Fibonacci numbers
				.forEach(System.out::println);

		System.out.println("Using method ref");
		NumberUtil util = new NumberUtil();
		IntStream.generate(util::getNextFibNum).limit(10).forEach(System.out::println);
	}

	// this nested class is to use method reference for Fibonaccu sequence
	static final class NumberUtil {
		private int prev = 0, curr = 1;

		public int getNextFibNum() {
			int next = prev + curr;
			prev = curr;
			curr = next;
			return next;
		}

	}

	// lower to upper case
	public static void changeCaseStrings() {
		Stream.of("foo", "bar", " ").filter(Predicate.not(String::isBlank)).map(s -> s.toUpperCase()).toList()
				.forEach(System.out::println); // use method reference directly

		Stream.of("foo", "bar", " ").filter(s -> !s.isBlank()).map(s -> s.toUpperCase()).toList()
				.forEach(System.out::println); // use lambda expression

	}

	/*
	 * Stream iterate demo
	 * 
	 * <p>Parameters: This method accepts three parameters: seed: which is the
	 * initial element, hasNext: which is a predicate to apply to elements to
	 * determine when the stream must terminate and next: which is a function to be
	 * applied to the previous element to produce a new element. </p>
	 * 
	 */
	public static void streamIteratorDemo() {
		// create a stream using iterate
		Stream<Integer> stream = Stream.iterate(1, i -> i <= 20, i -> i * 2);
		stream.forEach(System.out::println);

	}
}
