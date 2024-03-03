package com.demo.UEMassig;

import java.math.BigDecimal;

public class EmployeeEntity {
	String agt_id;
	String agt_name;
	String agt_gender;
	String agt_age;
	String agt_address;
	BigDecimal salary;

	public EmployeeEntity() {
		// TODO Auto-generated constructor stub
	}

	public EmployeeEntity(String agt_name, String agt_gender, String agt_age, String agt_address, BigDecimal salary) {

		this.agt_name = agt_name;
		this.agt_gender = agt_gender;
		this.agt_age = agt_age;
		this.agt_address = agt_address;
		this.salary = salary;
	}

	public EmployeeEntity(String agt_id, String agt_name, String agt_gender, String agt_age, String agt_address,
			BigDecimal salary) {

		this.agt_id = agt_id;
		this.agt_name = agt_name;
		this.agt_gender = agt_gender;
		this.agt_age = agt_age;
		this.agt_address = agt_address;
		this.salary = salary;
	}

}
