package com.demo.dsa;

public class LinkedListADT {

	private int length;
	private ListNode headNode;

	public LinkedListADT() {
		this.headNode = null; // null object
		length = 0;
	}

	public int ListLength(ListNode headNode) {

		ListNode temp = null;
		if (headNode != null) {
			temp = headNode;

			while (temp != null) {
				this.length++;
				temp = temp.getNextNode();
			}

		} else {
			throw new NullPointerException("head node is null");
		}

		return this.length;
	}

	synchronized public ListNode getHeadNode() {
		return this.headNode;
	}

	synchronized public void insertAtBeg(final ListNode currNode) {
		currNode.setNextNode(headNode);
		this.headNode = currNode;
	}

}
