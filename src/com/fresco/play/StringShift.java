package com.fresco.play;

import java.util.Scanner;

class SolutionStringShift {

	public String inputString;
	public int alphReducP;
	public int alphReducQ;

	public SolutionStringShift(String inputString, int alphReducP, int alphReducQ) {
		super();
		this.inputString = inputString;
		this.alphReducP = alphReducP;
		this.alphReducQ = alphReducQ;
	}

	int Solve() {
		boolean flag = false;
		String inpStringRef = this.inputString;
		String tempStr = "";
		int count = 0;
		while (true) {
			String subString = this.inputString.substring(this.inputString.length() - alphReducP);
			tempStr = getMergedString(this.inputString.substring(0, this.inputString.length() - (alphReducP)),
					subString);

			if (!tempStr.equals(inpStringRef)) {
				count++; // count for Q processed
				tempStr = getMergedString(tempStr.substring(0, tempStr.length() - (alphReducQ)),
						tempStr.substring(tempStr.length() - alphReducQ));

				if (tempStr.equals(inpStringRef)) {
					flag = true;
					break;
				}
				inputString = tempStr; // replace
			} else {
				flag = true;
				break;
			}

			count++; // count for P processed
			if (count == inpStringRef.length())
				break;

		}
		// System.out.println("Solution.Solve() :: count -> " + count + 1);
		return flag ? count + 1 : 0;
	}

	String getMergedString(String inputString, String subStr) {

		return subStr.concat(inputString);
	}
}

public class StringShift {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String inpt = sc.nextLine();
		int aplhRedcutionP = sc.nextInt();
		int alphReductionQ = sc.nextInt();

		SolutionStringShift solution = new SolutionStringShift(inpt, aplhRedcutionP, alphReductionQ);
		System.out.println(solution.Solve());

		sc.close();
	}

}
