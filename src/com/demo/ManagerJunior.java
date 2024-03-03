package com.demo;

public class ManagerJunior extends ManagerSenior {

	String inveAcc;
	String logiAcc;

	public ManagerJunior(String finAcc, String regAcc, String treAcc, String inveAcc, String logiAcc) {
		super(finAcc, regAcc, treAcc);
		this.inveAcc = inveAcc;
		this.logiAcc = logiAcc;
	}

	// Default
	public ManagerJunior() {
		super();
	}

	public ManagerJunior(String inveAcc, String logiAcc) {
		super();
		this.inveAcc = inveAcc;
		this.logiAcc = logiAcc;
	}

	@Override
	public void checkFinAcc() {
		System.out.println("Manager Junior has finAcc: Auditor");
	}

}
