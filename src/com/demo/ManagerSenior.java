package com.demo;

public class ManagerSenior {

	String finAcc = "A";
	String regAcc = "A";
	String treAcc = "A";

	public ManagerSenior() {
		// TODO Auto-generated constructor stub
	}

	public ManagerSenior(String finAcc, String regAcc, String treAcc) {
		super();
		this.finAcc = finAcc;
		this.regAcc = regAcc;
		this.treAcc = treAcc;
	}

	public void checkFinAcc() {
		System.out.println("Manager Senior has finAcc: Supervisor");
	}

	public void checkAllowance() {
		System.out.println("Manger is eligible for 15%");
	}
};
