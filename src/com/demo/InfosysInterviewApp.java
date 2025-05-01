package com.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class InfosysInterviewApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// input 4 6 8 10 -- any number
		// 3
		// need to find out the minimum and maximum number
		// 1. List -> sort
		// 2.Stream api

		// spring.hikari.database, spring.datasource.user, password , timeouts

		int n;

		Scanner sc = new Scanner(System.in);
		List<Integer> numList = List.of(3, 4, 1, 10, 13);
		List<Integer> inputList = new ArrayList<>();

		Optional<Integer> maxElem = numList.stream().max(Comparator.comparing(Integer::valueOf));

		Optional<Integer> minElem = numList.stream().min(Comparator.comparing(Integer::valueOf));

		System.out.println("Max elem: " + maxElem.get());
		System.out.println("Min elem: " + minElem.get());

		try {

			n = sc.nextInt();

			for (int i = 0; i < n; i++) {
				int t = sc.nextInt();

				inputList.add(t);
			}

			Collections.sort(inputList);

			System.out.println("Min elem: " + inputList.get(0));
			System.out.println("Max elem: " + inputList.get(inputList.size() - 1));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
	}

}
