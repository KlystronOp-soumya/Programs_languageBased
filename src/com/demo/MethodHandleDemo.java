package com.demo;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.invoke.MethodType;
import java.lang.invoke.VarHandle;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
class Student {

	public static int numOfObjects;

	private String name, course;

	public Student() {
		numOfObjects++;
	}

	public Student(final String name, final String course) {
		this();
		this.name = name;
		this.course = course;

	}

	public Student name(final String name) {
		this.name = name;
		return this;
	}

	public Student course(final String course) {
		this.course = course;
		return this;
	}

	public static void showCreatedObjects(int num) {
		System.out.println(numOfObjects);
		numOfObjects = num;
	}
}

public class MethodHandleDemo {

	public static void main(String[] args) throws Throwable {
		Lookup lookup = MethodHandles.lookup();
		Class<?> clazz = lookup.findClass(Student.class.getName());

		MethodType methodType = MethodType.methodType(String.class);

		Student s1 = new Student().name("John Doe").course("Learning Java");

		MethodHandle getCourseHandle = lookup.findVirtual(clazz, "getCourse", methodType);

		System.out.println(getCourseHandle.invoke(s1));

		// handler for constructor
		MethodType voidType = MethodType.methodType(void.class);
		MethodHandle noArgHandle = lookup.findConstructor(clazz, voidType);

		Student s2 = (Student) noArgHandle.invoke();
		s2.setName("Jane Dow");
		s2.setCourse("Learning CPP");
		System.out.println(s2);

		// parametarized constructor
		MethodType type2 = MethodType.methodType(void.class, String.class, String.class);// first type is the return
																							// type of the method
		MethodHandle paraCons = lookup.findConstructor(clazz, type2);
		Student s3 = (Student) paraCons.invoke("Mark J", "Learning C");

		System.out.println(s3);

		// invoke a setter method
		MethodType methodType3 = MethodType.methodType(void.class, String.class);
		MethodHandle setNameHandle = lookup.findVirtual(clazz, "setName", methodType3);
		setNameHandle.invoke(s3, "Marry J");
		System.out.println(s3);

		// handle statics
		MethodType methodType4 = MethodType.methodType(void.class, int.class);
		MethodHandle staticMethodHandle = lookup.findStatic(clazz, "showCreatedObjects", methodType4);
		staticMethodHandle.invoke(10);
		System.out.println(Student.numOfObjects);

		Lookup privateLookup = MethodHandles.privateLookupIn(clazz, lookup);

		// directly access getter and setter -- wihtout the private lookout it will
		// throw exception
		MethodHandle findGetter = privateLookup.findGetter(clazz, "name", String.class);
		MethodHandle findSetter = privateLookup.findSetter(clazz, "name", String.class);

		findSetter.invoke(s1, "Justin");

		// varHandles to access the variables/fields Java 9
		VarHandle courserVarHandle = privateLookup.findVarHandle(clazz, "course", String.class);
		String val = (String) courserVarHandle.get(s1);
		System.out.println(val);
		courserVarHandle.set(s1, "Kotlin");
		val = (String) courserVarHandle.get(s1);
		System.out.println(val);
	}

}
