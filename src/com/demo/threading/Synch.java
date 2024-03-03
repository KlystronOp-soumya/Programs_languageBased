package com.demo.threading;

class CallMe {

	void call(String msg) {
		System.out.println("[" + msg);
		try {
			Thread.sleep(1000);
			// System.out.println("The thread was stopped " + Thread.currentThread());

		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Interrupted");
		}
		System.out.println("]");
	}
}

class Caller implements Runnable {
	String msg;
	CallMe target;
	Thread t;

	public Caller(CallMe targ, String s) {
		target = targ;// dependency injection
		msg = s;
		t = new Thread(this);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		// to avoid the race condition add the synchronized
		// Now each thread waits for the previous thread to be completed

		synchronized (target) {
			target.call(msg);
		}

		// target.call(msg);

	}

}

public class Synch {

	public static void main(String[] args) {
		CallMe target = new CallMe();
		// calling same method on same object using three thread
		// hence results into race condition
		Caller obj1 = new Caller(target, "Hello");
		Caller obj2 = new Caller(target, "Synchronized");
		Caller obj3 = new Caller(target, "World");

		obj1.t.setName("thread 1");
		obj2.t.setName("thread 2");
		obj3.t.setName("thread 3");

		obj1.t.start();
		obj2.t.start();
		obj3.t.start();

		System.out.println("Thread in state: ");

		Thread.State tState = obj1.t.getState();

		// waiting for the threads to end
		try {
			obj1.t.join();
			// System.out.println("The thread: " + obj1.t.getName() + " is alive: " +
			// obj1.t.isAlive());
			obj2.t.join();
			// System.out.println("The thread: " + obj2.t.getName() + " is alive: " +
			// obj2.t.isAlive());
			obj3.t.join();
			// System.out.println("The thread: " + obj3.t.getName() + " is alive: " +
			// obj3.t.isAlive());
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
