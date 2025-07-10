package com.demo.dsa.linkedlist;

import lombok.Data;

@Data
public class SinglyLinkedListInnerADT<T> {

	private SinglyNode<T> head;

	/*
	 * Creates an empty list
	 */
	SinglyNode<T> createList() {
		head = new SinglyNode<T>();
		return head;
	}

	public class SinglyNode<T> {
		protected T data;
		protected SinglyNode nextNodeObject_address; // the object in Java is the address

		public SinglyNode() {
			this.data = null;
			nextNodeObject_address = null;

		}

		public SinglyNode(T data) {
			this.data = data;
			nextNodeObject_address = null; // points to nothing
		}
	}

	/*
	 * Counts the number of nodes present in the LinkedList
	 * 
	 * @returns int size
	 * 
	 */
	public int countNodes() {
		int sizeOfLL = 0;
		SinglyNode<T> temp = cloneHeadNode();
		if (this.head == null) {
			return sizeOfLL;
		} else {
			while (temp != null) {
				sizeOfLL++;
				// move the pointer to the next object/address
				temp = temp.nextNodeObject_address;
			}
		}
		return sizeOfLL;
	}

	/*
	 * Get the size of the linkedList using recursion
	 */
	int countNodes(SinglyNode<T> currNode) {
		int sizeOfLL = 0;
		if (currNode == null) {
			return 1;
		}
		sizeOfLL += countNodes(currNode.nextNodeObject_address); // recursive call with the next node object
		return sizeOfLL;
	}

	/*
	 * Show all the elements of the list
	 */
	public void displayList() {
		SinglyNode<T> tempHead = cloneHeadNode();// copies the head otherwise actual head will move to the end
		System.out.print("{ ");
		while (tempHead != null) {
			System.out.print(tempHead.data + " ");
			tempHead = tempHead.nextNodeObject_address;
		}
		System.out.print("} \n");

	}

	/*
	 * Deep copy to restrict movement of headNode to the end
	 */
	private SinglyNode<T> cloneHeadNode() {
		SinglyNode<T> cloned = new SinglyNode<>();
		cloned.data = this.head.data;
		cloned.nextNodeObject_address = this.head.nextNodeObject_address;

		return cloned;
	}

	public void dealloc() {
		while (this.head != null) {
			SinglyNode<T> temp = head;
			head = head.nextNodeObject_address;
			temp = null;
		}
		head = null;
	}
}
