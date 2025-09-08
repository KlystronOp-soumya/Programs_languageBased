package com.demo.version.features.feat11;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;

/*
 * In Java, a record is a special type of class declaration aimed at reducing the boilerplate code. 
 * Java records were introduced with the intention to be used as a fast way to create data carrier classes
 * 
 * Records are implicitly final and can not be abstract; polymorphic design is not possible wiht Records.
 * Records are immutable class and hence can not be extended
 *  
 * */

class EmployeePOJO {
	private int id;
	private String fName;
	private String lName;

	public int getid() {
		return id;
	}

	public void setid(int id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	@Override
	public int hashCode() {

		// Final variable
		final int prime = 31;
		int result = 1;

		result = prime * result + id;
		result = prime * result + ((fName == null) ? 0 : fName.hashCode());
		result = prime * result + ((lName == null) ? 0 : lName.hashCode());

		return result;
	}

	@Override
	public boolean equals(Object obj) {
		// This refers to current instance itself
		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (getClass() != obj.getClass())
			return false;

		EmployeePOJO other = (EmployeePOJO) obj;

		if (id != other.id)
			return false;

		if (fName == null) {
			if (other.fName != null)
				return false;
		}

		else if (!fName.equals(other.fName))
			return false;

		if (lName == null) {
			if (other.lName != null)
				return false;
		}

		else if (!lName.equals(other.lName))
			return false;

		return true;

	}
}

/*
 * You can use nested classes and interfaces inside a record. You can have
 * nested records too, which will implicitly be static. A record can implement
 * interfaces. You can create a generic record class. It is possible to use
 * local record classes (since Java SE 15). Records are serializable.
 */

//declare a record
record EmployeeRec(int id, String fName, String lName) {

	// it is not necessary to include anything else in the record but we can

	// define static fields, the instance fields are should be present
	static int countEmpRecs;

	// define a constructor of this record
	public EmployeeRec { // don't put empty parenthesis
		if (id < 100)
			throw new IllegalArgumentException("Employee id can not be less than 100");

		if (fName.length() < 2)
			throw new IllegalArgumentException("Length is not sufficient");

		increment();
	}

	EmployeeRec(int id, String fName) {
		this(id, fName, null); // the parameter value names must be same as the record args
		increment();
	}

	// define instance method
	public String getFullEmpName() {
		return fName.concat(lName);
	}

	public static void increment() {
		++countEmpRecs;
	}

}

public class RecordDemo {

	public static void main(String[] args) {

		EmployeeRec rec1 = new EmployeeRec(100, "John", "Doe");
		EmployeeRec rec2 = new EmployeeRec(101, "Martin", "Fowler");

		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
		out.println(rec1);
		out.flush();
	}

}
