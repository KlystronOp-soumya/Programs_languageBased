package com.demo.dao;

/*
 * Best practice create a sub package and place all the custom exception class */
public class CustomExceptions extends Throwable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomExceptions(String messageString) {
		super(messageString);
	}
	// make inner classes
}

class StudentNotFoundException extends CustomExceptions {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StudentNotFoundException(String messageString) {
		super(messageString);
	}
}

@SuppressWarnings("serial")
class StudentObjectCouldNotSave extends CustomExceptions {

	public StudentObjectCouldNotSave(String messageString) {
		super(messageString);
		// TODO Auto-generated constructor stub
	}

}