package com.demo.genericsenum;

public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Decide the Status based on duration

		System.out.println(Status.CREATED.getStatusVal());
		System.out.println(Status.CREATED.getCheckCreationTime());
		Status.CREATED.setStatus();
		System.out.println(Status.CREATED.getStatusVal());
		System.out.println(Status.CREATED.getCheckCreationTime());
		Status.PROCESSED.setStatus();
		System.out.println(Status.PROCESSED.getStatusVal());
		System.out.println(Status.PROCESSED.getCheckCreationTime());

		System.out.println(Status.ABORTED.getStatusVal());

	}

}
