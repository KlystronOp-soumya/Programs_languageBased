/**
 * 
 */
package com.demo.UEMassig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author SOUMYADEEP PAUL
 *
 */
public class AssignmentDriver {

	private static final int MAX = 1024;

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader ad = null;
		Scanner sc = null;
		char str[] = null;
		int strLen = -1;
		CustomStringApi string;
		try {
			ad = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter the length of the String: ");
			strLen = Integer.parseInt(ad.readLine());
			str = new char[strLen];
			System.out.println("Enter the String:");
			// creating the String
			for (int i = 0; i < strLen; i++) {
				char ch = (char) ad.read();
				str[i] = ch;
			}
			display(str);
			string = new CustomStringApi(str);// instansiated

			System.out.println(string.xLength());
			System.out.printf("Character at: 1 is %c", string.xCharAt(1));
			System.out.println("Concatenation: " + string.xConcat(str));
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getLocalizedMessage());
		} finally {
			if (null != ad) {
				ad.close();
			}

		}

	}

	private static void display(char[] str) {
		for (char c : str) {
			System.out.print(c);
		}
	}

	public static void arrayDemo() {
		int ar[] = new int[5];
		int ar2[][] = new int[4][5];
		int ar3[][] = new int[4][];
		int ar4[][][] = new int[4][4][4];

		ar3[0] = new int[2];
		ar3[1] = new int[3];

	}

}
