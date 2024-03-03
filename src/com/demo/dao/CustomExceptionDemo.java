package com.demo.dao;

class StudentExceptionDemo {

	public static boolean findStudent(String name) throws CustomExceptions {

		if (name.equalsIgnoreCase("Admin"))
			return true;
		else {
			throw new CustomExceptions("Check Proper Name");
		}
	}
}

public class CustomExceptionDemo {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentExceptionDemo objDemo = new StudentExceptionDemo();
		try {
			// this will throw the exception
			/*
			 * String nameString1 = "Soumya"; boolean dec =
			 * objDemo.findStudent(nameString1); System.out.println("Student Found: " +
			 * dec);
			 */
			String nameString2 = "admin";
			boolean dec2 = objDemo.findStudent(nameString2);
			System.out.println("Student Found: " + dec2);

		} catch (CustomExceptions e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
