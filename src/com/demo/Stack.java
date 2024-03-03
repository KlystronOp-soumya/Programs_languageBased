package com.demo;

public class Stack {

	private int[] stack;
	private int top;

	public Stack() {
		// TODO Auto-generated constructor stub
		top = -1;
	}

	public Stack(int size) {
		this.stack = new int[size];
		this.top = -1;
	}

	public void push(int val) {

		if (this.top == stack.length) {
			System.out.println("Stack is full");
			return;
		}
		this.stack[this.top++] = val;

	}

	public int pop() {
		if (this.top == -1) {
			System.out.println("Stack is empty");
			return -1;
		}
		int val = this.stack[this.top];
		--top;
		return val;
	}

	public void peek() {
		System.out.println("Top element: " + this.stack[this.top]);
	}

	void sum(int a, int b) {
		// shw a+b
	}

	void sum(double a, double b) {
		// shw a+b
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack st = new Stack();
		st.sum(0.00, 0.00);
	}

}
