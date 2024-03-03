package com.demo.threading;

class A {

	synchronized void foo(B b) {
		String name = Thread.currentThread().getName();

		System.out.println("name: " + name + " entered A.foo");
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("trying to call B.last() by: " + name);
		b.last();
	}

	synchronized void last() {
		System.out.println("Inside A.last");
	}
}

class B {

	synchronized void bar(A a) {
		String name = Thread.currentThread().getName();

		System.out.println("name: " + name + " entered B.bar");
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("trying to call A.last() by: " + name);
		a.last();
	}

	synchronized void last() {
		System.out.println("Inside B.last");
	}
}

public class DeadLockDemo implements Runnable {

	private transient A a;
	private transient B b;
	Thread thread;

	public DeadLockDemo() {
		// TODO Auto-generated constructor stub
		Thread.currentThread().setName("MainThread");
		a = new A();
		b = new B();
		thread = new Thread(this, "RacingThread");
	}

	void deadlocStart() {
		thread.start();
		this.a.foo(this.b);
		System.out.println("Back in main thread");
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.b.bar(this.a);
	}

	public static void main(String[] args) {
		DeadLockDemo dLockDemo = new DeadLockDemo();
		dLockDemo.deadlocStart();

	}

}
