package com.demo.dsa;

import com.demo.dsa.linkedlist.SinglyLinkedListInnerADT;

public class LinkedListDriver {

	public static void main(String[] args) {
		singlyLinkedListInnerADT();

	}

	/*
	 * Method to use the Inner class version of the LinkedList
	 */
	private static void singlyLinkedListInnerADT() {

		SinglyLinkedListInnerADT<Integer> list = new SinglyLinkedListInnerADT();
		for (int i = 0; i < 11; i++) {
			list.appned(i);
		}
		System.out.println("Size of the list: " + list.countNodes());
		list.displayList();
		for (int i = 13; i < 23; i++) {
			list.addBeg(i);
		}
		list.displayList();
	}

}
