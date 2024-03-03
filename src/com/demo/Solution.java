package com.demo;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

@SuppressWarnings({ "unused", "rawtypes" })
class Toy implements Comparable {

	private int toyId;
	private String toyType;
	private double toyPrice;
	private double ToyRating;

	public Toy(int toyId, String toyType, double toyPrice, double toyRating) {
		super();
		this.toyId = toyId;
		this.toyType = toyType;
		this.toyPrice = toyPrice;
		ToyRating = toyRating;
	}

	public int getToyId() {
		return toyId;
	}

	public void setToyId(int toyId) {
		this.toyId = toyId;
	}

	public String getToyType() {
		return toyType;
	}

	public void setToyType(String toyType) {
		this.toyType = toyType;
	}

	public double getToyPrice() {
		return toyPrice;
	}

	public void setToyPrice(double toyPrice) {
		this.toyPrice = toyPrice;
	}

	public double getToyRating() {
		return ToyRating;
	}

	public void setToyRating(double toyRating) {
		ToyRating = toyRating;
	}

	@Override
	public String toString() {
		return "Toy [toyId=" + toyId + ", toyType=" + toyType + ", toyPrice=" + toyPrice + ", ToyRating=" + ToyRating
				+ "]";
	}

	public int compareTo(Toy obj) {
		// TODO Auto-generated method stub
		int comparePrice = (int) obj.getToyPrice();
		/* For Ascending order */
		return (int) (this.toyPrice - comparePrice);

	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

}

@SuppressWarnings("unused")
public class Solution {

	public static int getAvgRatingBasedOntype(Toy[] toy_objs, String st) {
		double sum = 0.0;
		int nof_obj = toy_objs.length;
		for (Toy each_obj : toy_objs) {
			if (each_obj.getToyType().equalsIgnoreCase(st))
				sum += each_obj.getToyRating();
		}
		int res = (int) ((sum != 0) ? Math.round(sum / nof_obj) : -1);
		return res;// rounds of to the next integer
	}

	@SuppressWarnings("unchecked")
	public static Toy getSecondCheapestToyAsPerRating(Toy[] toy_objs, double d) { // prints type and the price

		ArrayList<Toy> tempList = new ArrayList<Toy>();
		for (Toy each_Toy : toy_objs) {
			if (each_Toy.getToyRating() >= d) {
				tempList.add(each_Toy);
			}
		}
		if (tempList.isEmpty())
			return null;
		else {
			Collections.sort(tempList);

			return tempList.get(1);// object at the first index

		}
	}

	@SuppressWarnings({ "resource", "deprecation" })
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

		final int n = 4;

		int id;
		String typeString;
		double price;
		double rating;

		String sr_type;
		double sr_Rating;
		try {

			// n = scanner.nextInt();
			Toy[] obj_lisToys = new Toy[n];
			// array created
			for (int i = 0; i < n; ++i) {
				id = scanner.nextInt();
				typeString = scanner.next();
				price = scanner.nextDouble();
				rating = scanner.nextDouble();
				// creating obj
				Toy objToy = new Toy(id, typeString, price, rating);

				obj_lisToys[i] = objToy;
			}
			sr_type = scanner.next();
			sr_Rating = scanner.nextDouble();

			// call to the methods since static without referrence

			int avgres = getAvgRatingBasedOntype(obj_lisToys, sr_type);
			Toy obj2 = getSecondCheapestToyAsPerRating(obj_lisToys, sr_Rating);

			if (obj2 != null)
				System.out.println(obj2.getToyType() + " " + obj2.getToyPrice());
			else {
				out.println("There is no such toy");
			}
			if (avgres != -1)
				out.print(avgres);
			else {
				out.print("There is no such object");
			}

		}

		catch (Exception e) {// TODO: handle exception
			out.print("ERROR:" + e);
		}

		finally {
			scanner.close();
		}
	}
}
