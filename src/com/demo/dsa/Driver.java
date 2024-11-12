package com.demo.dsa;

public class Driver {

	public static void main(String[] args) {

		LinkedListADT linkedList = new LinkedListADT();
		ListNode headNode = new ListNode(11);
		linkedList.setHeadNode(headNode);
		ListNode nextNode1 = new ListNode(12);
		headNode.setNextNode(nextNode1);
		linkedList.displayList();

	}

}
