package com.fresco.play;

import java.util.Scanner;

class Validator {
	public static boolean validate(String message) {
		return message.matches("[A-Za-z0-9 ]+");
	}
}

//implements the encryption validation
class Encrypter {

	public static String encryptMessage(String message) throws InvalidMessageException {

		StringBuffer stbfBuffer;
		if (Validator.validate(message)) // true
		{
			message = message.toLowerCase();
			stbfBuffer = new StringBuffer(message);
			stbfBuffer.reverse();
			return stbfBuffer.toString();

		} else {
			throw new InvalidMessageException();
		}

	}

}

//implements the custom exception class
class InvalidMessageException extends Exception {
	/**
	 * @author SOUMYADEEP PAUL
	 * @returns custom exception message
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "InvalidMessageException:Try again with proper message";
	}

	/*
	 * public String toString(String messageString) { return messageString; }
	 */

}

public class FrescoUserDefinedExceptionSolution {
	private static final Scanner INPUT_READER = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the name: ");
		String message = INPUT_READER.nextLine();

		try {
			String encrypted_message = Encrypter.encryptMessage(message);
			if (!encrypted_message.startsWith("InvalidMessageException"))
				System.out.println(encrypted_message);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		} finally {
			INPUT_READER.close();
		}
	}
}
