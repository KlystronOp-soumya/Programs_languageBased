package com.demo.dsa.linkedlist;

public class LinkedListDriver {

	public static void main(String[] args) {
		singlyLinkedListInnerADT();

	}

	/*
	 * Method to use the Inner class version of the LinkedList
	 */
	private static void singlyLinkedListInnerADT() {

		SinglyLinkedListInnerADT<Integer> linkedList = new SinglyLinkedListInnerADT<>();
		SinglyLinkedListInnerADT<Integer>.SinglyNode<Integer> headNode = linkedList.new SinglyNode<Integer>();
		linkedList.setHead(headNode);
		headNode.data = 1;
		linkedList.displayList();
		System.out.println("Number of nodes: " + linkedList.countNodes());
		SinglyLinkedListInnerADT<Integer>.SinglyNode<Integer> node2 = linkedList.new SinglyNode<Integer>();
		node2.data = 2;
		SinglyLinkedListInnerADT<Integer>.SinglyNode<Integer> ht = linkedList.getHead();
		ht.nextNodeObject_address = node2;
		linkedList.displayList();

		SinglyLinkedListInnerADT<Integer>.SinglyNode<Integer> node3 = linkedList.new SinglyNode<Integer>();
		node3.data = 3;
		SinglyLinkedListInnerADT<Integer>.SinglyNode<Integer> ht2 = linkedList.getHead();
		ht2.nextNodeObject_address.nextNodeObject_address = node3;
		linkedList.displayList();
		linkedList.dealloc();

	}

}
