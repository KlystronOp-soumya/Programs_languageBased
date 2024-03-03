/**
 * 
 */
package com.demo.lambdas;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * @author USER
 * 
 *         Demonstrates some use cases of Lambda , Annonymous class and Method
 *         reference
 *
 */

@FunctionalInterface
interface CipherInterface {

	void getCipher(List<String> list);

}

class Cipher_Annonymous {
	void cipherAnnonymous(final List<String> list) {

	}
}

class Cipher_MethodRef {
	void cipherMethodRef(final List<String> list) {
		final String cipheredString = list.stream()
				.map((eachStringInList) -> eachStringInList.equals(" ") ? eachStringInList
						: (int) eachStringInList.charAt(0) + eachStringInList.substring(1))
				.map((eachStringInList) -> eachStringInList.replace(" ", "#$")).map(StringBuilder::new)
				.map(StringBuilder::reverse).map(StringBuilder::toString).collect(Collectors.joining());

		System.out.println(cipheredString);
	}
}

class Cipher_Lambda {
	void cipherLambda(final List<String> list) {
		// get the tokenized list
		// convert first character of each list elements into its ASCII value
		// replace spaces with #$
		// reverse each element
		// print the list elements concatenated

		final String cipheredString = list.stream()
				.map((eachStringInList) -> (int) eachStringInList.charAt(0) + eachStringInList.substring(1))
				.map((eachStringInList) -> eachStringInList.replace(" ", "#$")).map(StringBuilder::new)
				.map(StringBuilder::reverse).map(StringBuilder::toString).collect(Collectors.joining());

		System.out.println(cipheredString);

	}
}

public class CipherMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input;
		List<String> textList = new ArrayList<>();
		try {
			input = sc.nextLine();
			StringTokenizer stringTokenizer = new StringTokenizer(input, " ");
			while (stringTokenizer.hasMoreElements()) {
				textList.add(stringTokenizer.nextElement().toString());
			}

			Cipher_MethodRef cipher_MethodRef = new Cipher_MethodRef();
			getCipher(cipher_MethodRef::cipherMethodRef, textList);
		} catch (Exception e) {
			PrintWriter out = new PrintWriter(System.out);
			e.printStackTrace(out);
		} finally {
			sc.close();
		}

	}

	public static void getCipher(CipherInterface cipher, final List<String> textList) {
		cipher.getCipher(textList);
	}

}
