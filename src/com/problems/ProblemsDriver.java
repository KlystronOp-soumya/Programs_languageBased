package com.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ProblemsDriver {

	public static void main(String[] args) throws IOException {
		// bubbleSort();
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		for (int i = 0; i < 10; i++) {
			pq.add(i);

		}

		System.out.println(pq.element());
	}

	public static void checkAnagram() {
		String st1 = "worldllheo";
		String st2 = "Helloworld";
		// get the arrays
		char[] ar1 = st1.toCharArray();
		char[] ar2 = st2.toCharArray();
		// now sort both the arrays
		Arrays.sort(ar1);
		Arrays.sort(ar2);

		System.out.println(Arrays.equals(ar1, ar2));

	}

	public static void bubbleSort() throws IOException {
		int[] ar = new int[] { 3, 4, -1, 0, 5 };
		boolean swapped = true;
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		try {
			/*
			 * for (int i = 0; i < 5; i++) { ar[i] = Integer.parseInt(rd.readLine()); }
			 */

			for (int pass = ar.length - 1; pass >= 0 && swapped; pass--) {
				swapped = false;
				for (int i = pass + 1; i < ar.length - 1; i++) {
					if (ar[i] > ar[i + 1]) {
						int temp = ar[i];
						ar[i] = ar[i + 1];
						ar[i + 1] = temp;
						swapped = true;
					}
				}
			}

			for (int i = 0; i < ar.length; i++) {
				System.out.println(ar[i]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rd.close();
		}

	}
}
