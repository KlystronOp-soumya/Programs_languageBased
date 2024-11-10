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

	synchronized public void appendNode(ListNode headNode, final int data) {

		ListNode temp, r;
		// check if the headNode is null
		if (headNode == null) {
			// create a temporary
			temp = new ListNode(data);
			headNode = temp;
		} else {
			temp = headNode;
			while (temp.getNextNode() != null) {
				temp = temp.getNextNode();
			}

			r = new ListNode(data);
			temp = r;
		}
	}

}
