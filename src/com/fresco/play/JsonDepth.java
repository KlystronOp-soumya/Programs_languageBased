package com.fresco.play;

import java.util.Scanner;

class SolutionJsonDepth {

	String inputString;

	public SolutionJsonDepth(String inputString) {
		super();
		this.inputString = inputString;
	}

	int solve() {

		int curLevel = 1; // satrts from 1
		int maxLevel = Integer.MIN_VALUE;

		char[] jsonArray = inputString.toCharArray();
		for (int i = 0; i < jsonArray.length; i++) {

			if (jsonArray[i] == '{') {
				curLevel++;
				if (maxLevel < curLevel)
					maxLevel = curLevel;
			} else if (jsonArray[i] == '}') {
				curLevel--;
			}

		}

		return maxLevel - 1;
	}

}

public class JsonDepth {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String inputJson = sc.nextLine();
		sc.close();

		SolutionJsonDepth solutionJsonDepth = new SolutionJsonDepth(inputJson);
		System.out.println(solutionJsonDepth.solve());
	}

}
