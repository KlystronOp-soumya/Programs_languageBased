package com.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentDaoDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		List<Student> studentObjList = new ArrayList<>();

		for (int i = 0; i < 3; ++i) {
			Student student = new Student();
			student.setName(scanner.next());
			student.setRoll(scanner.nextInt());
			student.setMarks(scanner.nextFloat());

			// add to the list
			studentObjList.add(student);
		}

		// create the repo obje
		StudentRepository studentRepository = new StudentRepository();
		boolean isSaved = studentRepository.saveEntry(studentObjList);
		if (isSaved)
			System.out.println("Saved");
		else {
			System.out.println("Not Saved");
		}

		studentRepository.getAll().forEach((each_st) -> System.out.println(each_st));
	}

}
