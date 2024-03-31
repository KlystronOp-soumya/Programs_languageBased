package com.demo;

enum ResultStatus {
	// abstract methods can be added to enums
	PASS(1) {
		@Override
		public boolean isStatus() {

			return super.isStatus();
		}
	},
	FAIL(0) {
		@Override
		public boolean isStatus() {

			return super.isStatus();
		}
	},
	PENDING(-1) {
		@Override
		public boolean isStatus() {
			// TODO Auto-generated method stub
			return super.isStatus();
		}
	};

	private int conditionCode;

	ResultStatus(int i) {
		conditionCode = i;
	}

	int getConditionCode() {
		return conditionCode;
	}

	public boolean isStatus() {
		return false;
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
