package com.demo.dsa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SinglyLinkedListADT {

	@Getter
	@Setter
	@AllArgsConstructor
	class SinglyLinkedListNode {
		private int data;
		private SinglyLinkedListNode nextNode;

		public SinglyLinkedListNode(final int data) {

			this(data, null);

		}
	}

	private SinglyLinkedListNode headNode;

	synchronized void addAtBeg(final SinglyLinkedListNode currNode) {
		if (this.headNode == null) {
			this.headNode = currNode;
		} else {
			currNode.setNextNode(this.headNode);
			this.headNode = currNode;
		}
	}

	synchronized void display() {
		while (this.headNode != null) {
			System.out.println(this.headNode.getData());
			this.headNode = headNode.getNextNode();
		}
	}

	public static void main(String[] args) {

		SinglyLinkedListADT singlyLinkedListADT = new SinglyLinkedListADT();
		SinglyLinkedListADT.SinglyLinkedListNode head = singlyLinkedListADT.new SinglyLinkedListNode(11);
		singlyLinkedListADT.setHeadNode(head);
		singlyLinkedListADT.addAtBeg(singlyLinkedListADT.new SinglyLinkedListNode(12));

		singlyLinkedListADT.display();

	}
}
