package com.demo.MethodReference;

import java.util.ArrayList;
import java.util.Collections;

//Sorting a list without using the comaparator

class Student {
	private String name;
	private int roll;
	private double marks;

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	int getRoll() {
		return roll;
	}

	void setRoll(int roll) {
		this.roll = roll;
	}

	double getMarks() {
		return marks;
	}

	void setMarks(double marks) {
		this.marks = marks;
	}

}

public class StudentSortOnMarksDemo {

	// must return int otherwise it will show error
	static int compareST(Student studentObj1, Student studentObj2) {
		return (int) (studentObj1.getMarks() - studentObj2.getMarks());

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Student> students_obj = new ArrayList<>();

		Student obj1 = new Student();
		Student obj2 = new Student();
		Student obj3 = new Student();

		obj1.setName("asdac");
		obj1.setRoll(1);
		obj1.setMarks(100);

		obj2.setName("afefr");
		obj2.setRoll(2);
		obj2.setMarks(98);

		obj3.setName("adsafwef");
		obj3.setRoll(3);
		obj3.setMarks(90);

		students_obj.add(obj1);
		students_obj.add(obj2);
		students_obj.add(obj3);

		// before sorting
		// System.out.println(students_obj);
		// after sorting
		Student max_obj = Collections.max(students_obj, StudentSortOnMarksDemo::compareST);
		System.out.println("Max result: " + (int) max_obj.getMarks());
	}

}
