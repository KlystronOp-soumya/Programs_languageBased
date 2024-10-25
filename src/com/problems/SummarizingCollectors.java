package com.problems;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
class Employee {
	private String name;
	private Integer age;
	private Double salary;
	private long leaves;

}

public class SummarizingCollectors {
	static List<Employee> employeeList = Arrays.asList(new Employee("Tom Jones", 45, 15000.00, 190),
			new Employee("Tom Jones", 45, 7000.00, 220), new Employee("Ethan Hardy", 65, 8000.00, 1008),
			new Employee("Nancy Smith", 22, 10000.00, 5), new Employee("Deborah Sprightly", 29, 9000.00, 45));

	public static void main(String[] args) {
		// Using Collectors.summarizingInt()
		IntSummaryStatistics intSummaryStatistics = employeeList.stream()
				.collect(Collectors.summarizingInt(Employee::getAge));
		System.out.println("IntSummaryStatistics for age: " + intSummaryStatistics);

		// Using Collectors.summarizingLong()
		LongSummaryStatistics longSummaryStatistics = employeeList.stream()
				.collect(Collectors.summarizingLong(Employee::getLeaves));
		System.out.println("LongSummaryStatistics for leaves: " + longSummaryStatistics);

		// Using Collectors.summarizingDouble()
		DoubleSummaryStatistics doubleSummaryStatistics = employeeList.stream()
				.collect(Collectors.summarizingDouble(Employee::getSalary));
		System.out.println("DoubleSummaryStatistics for salary: " + doubleSummaryStatistics);
	}
}
