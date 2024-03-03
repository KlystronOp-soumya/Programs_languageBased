package com.demo;

enum ResultStatus {
	PASS(1), FAIL(0), PENDING(-1);

	private int conditionCode;

	ResultStatus(int i) {
		// TODO Auto-generated constructor stub
		conditionCode = i;
	}

	int getConditionCode() {
		return conditionCode;
	}
}

public class EnumDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// intialize the enum objects
		ResultStatus rStatus;
		// print the values
		rStatus = ResultStatus.PASS;
		System.out.println("The status is: " + rStatus);
		System.out.println("The status value is : " + ResultStatus.valueOf("PENDING"));

		// print all the ojects
		ResultStatus[] resultStatus = ResultStatus.values();

		for (ResultStatus r : resultStatus) {
			System.out.println("The object: " + r + " value: " + r.getConditionCode());
		}

	}

}
