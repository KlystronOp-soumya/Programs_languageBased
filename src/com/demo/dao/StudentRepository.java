package com.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StudentRepository implements Dao<Student, Integer> {

	Scanner scanner = new Scanner(System.in);
	private List<Student> studentObjectList;

	public StudentRepository() {
		studentObjectList = new ArrayList<>();
	}

	@Override
	public boolean saveEntry(List<Student> st) {
		// TODO Auto-generated method stub
		try {
			studentObjectList = st;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public List<Student> getAll() {
		// TODO Auto-generated method stub
		try {
			if (!((int) studentObjectList.parallelStream().count() == 0)) {
				return studentObjectList;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public Student getByAttribute(Integer roll) {
		// TODO Auto-generated method stub
		// int r = roll; //we dont need this since auto unboxing is done here
		List<Student> foundStudentObj = studentObjectList.parallelStream()
				.filter((each_studentObject) -> each_studentObject.getRoll() == roll).collect(Collectors.toList());

		if (!foundStudentObj.isEmpty())
			return foundStudentObj.get(0);

		return null;
	}

	@Override
	public boolean updateAttribute(Integer roll) {
		// TODO Auto-generated method stub
		// first find the student
		/*
		 * List<Student> foundStudentObjectList =
		 * studentObjectList.stream().filter((each_st) -> each_st.getRoll() == roll)
		 * .collect(Collectors.toList());
		 */

		Student tempObjStudent = getByAttribute(roll);

		if (tempObjStudent != null) {
			System.out.println("Student Found");
			tempObjStudent.setName(scanner.next());
			tempObjStudent.setMarks(scanner.nextFloat());
			studentObjectList.forEach((each_obj) -> System.out.println(each_obj));
			return true;
		} else

			return false;
	}

	@Override
	public boolean deleteEntry(Integer r) {
		// TODO Auto-generated method stub
		// find the object
		return false;
	};// default constructor

}
