package com.fresco.play;

class CipherDecipher1 {

	@SuppressWarnings("null")
	public String ciphering(String normal) {
		StringBuilder cipherBuilder;
		String finalCipherBuilder = "";
		// converting to mutable
		// convert the Lower ot Upper V&V
		String tempString = "";
		for (int i = 0; i < normal.length(); ++i) {
			if (Character.isUpperCase(normal.charAt(i))) {
				tempString += Character.toLowerCase(normal.charAt(i));
			} else if (Character.isLowerCase(normal.charAt(i))) {
				tempString += Character.toUpperCase(normal.charAt(i));
			} else {
				tempString += normal.charAt(i);
			}

		}
		String tempString2 = tempString.replaceAll("\\s", "*");
		cipherBuilder = new StringBuilder(tempString2);
		cipherBuilder.reverse();

		for (int i = 0; i < cipherBuilder.length(); ++i) {
			if ((i & 1) != 1 && cipherBuilder.charAt(i) != '*') {

				Integer ascii = Integer.valueOf(cipherBuilder.charAt(i));
				// System.out.println("Char: " + cipherBuilder.charAt(i) + " ascii: " + ascii);
				finalCipherBuilder += ascii.toString();

			} else {
				finalCipherBuilder += cipherBuilder.charAt(i);
			}
		}

		System.out.println(tempString2);
		System.out.println(cipherBuilder);
		System.out.println(finalCipherBuilder);
		return finalCipherBuilder;
	}

	public String deciphering(String ciphered) {
		return null;
	}
}

public class CipherDecipherApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CipherDecipher1 objCipherDecipher1 = new CipherDecipher1();
		System.out.println(objCipherDecipher1.ciphering("Welcome to hackerrank"));
		;
	}

}
