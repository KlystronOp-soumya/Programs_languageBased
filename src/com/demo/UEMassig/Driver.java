package com.demo.UEMassig;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Driver {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// local variable declaration
		String agt_name = "";
		String agt_gender = "";
		String agt_age = "";
		String agt_address = "";
		BigDecimal salary = null;
		try {
			EmployeeEntity ent = new EmployeeEntity(agt_name, agt_gender, agt_age, agt_address, salary);
			EmployeeEntity[] empArray = new EmployeeEntity[5];
			List<EmployeeEntity> empList = new ArrayList<EmployeeEntity>();

			// adding objects
			empList.add(new EmployeeEntity());
			empList.add(new EmployeeEntity());
			empList.add(new EmployeeEntity());

			for (EmployeeEntity eachObject : empList) {
				System.out.println(eachObject);
			}

			int[] ar = { 1, 2, 3, 4, 5, 6 };
			ar[0] = 100;

			for (int i = 0; i < ar.length; i++) {
				System.out.println(ar[i]);
			}

			for (int i : ar) {
				System.out.println(i);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
