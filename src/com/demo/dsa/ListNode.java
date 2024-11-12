package com.demo.dsa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListNode {

	private int data;
	/*
	 * In case of CPP / C this would have been a structure pointer
	 * 
	 * In Java objects are primarily reference to the memory which is similar to the
	 * pointer which stores the memory address
	 * 
	 * 
	 */
	private ListNode nextNode;

	ListNode(final int data) {
		// this(data, null);

		this.data = data;
		this.nextNode = null;
	}

}
