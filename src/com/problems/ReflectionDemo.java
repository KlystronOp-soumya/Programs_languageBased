package com.problems;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;

class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	private String FName;
	private String LName;
	private String age;
	private String salary;

	public String getFName() {
		return FName;
	}

	public void setFName(String fName) {
		FName = fName;
	}

	public String getLName() {
		return LName;
	}

	public void setLName(String lName) {
		LName = lName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

}

public class ReflectionDemo {

	public static void main(String[] args)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		Object personObject = new Person();

		// get the field name
		Field[] fields = personObject.getClass().getDeclaredFields();

		// get the class name
		Class<?> clazz = personObject.getClass();

		System.out.println("Class Name: " + clazz.getName());
		System.out.println("Package Name: " + clazz.getPackageName());
		System.out.println("Method Names");

		for (Method m : clazz.getMethods()) {
			System.out.println(m.getName() + " " + Modifier.isPublic(m.getModifiers()));
			if (m.getName().equals("setFName")) {
				m.invoke(personObject, "Soumya");

			}
			if (m.getName().equals("getFName")) {
				System.out.println("Ref:" + m.invoke(personObject));

			}
		}

		List<String> fieldNames = Arrays.asList(fields).stream().map((eachField) -> eachField.getName()).toList();
		fieldNames.stream().forEach(System.out::println);
	}

}
