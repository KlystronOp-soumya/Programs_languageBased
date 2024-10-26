package com.problems;

class ThreadDem1 implements Runnable {

	@Override
	public void run() {
		Thread.State threadState = Thread.currentThread().getState();
		System.out.println("state: " + threadState.toString());
		try {
			for (int i = 1; i <= 5; i++) {
				System.out.println("T1:: i-> " + i);
				Thread.sleep(1000);
				threadState = Thread.currentThread().getState();
				System.out.println("state: " + threadState.toString());
			}

		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

}

class ThreadDem2 implements Runnable {

	@Override
	public void run() {
		Thread.State threadState = Thread.currentThread().getState();
		System.out.println("state: " + threadState.toString());
		try {

			for (int i = 1; i <= 5; i++) {
				System.out.println("T2:: i-> " + i);
				Thread.sleep(500);
			}

		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

}

public class ThreadDemo {

	public static void main(String[] args) throws InterruptedException {

		Runnable thread1 = new ThreadDem1();
		Runnable thread2 = new ThreadDem2();

		Thread t1 = new Thread(thread1, "T1_DEM1");
		Thread t2 = new Thread(thread2, "T2_DEM2");
		System.out.println(t1.getState().toString());
		t1.start();
		System.out.println(t1.getState().toString());
		System.out.println(t2.getState().toString());
		t2.start();
		System.out.println(t2.getState().toString());
		// while (t1.isAlive() || t2.isAlive()) {

		System.out.println("Current Thread name: " + Thread.currentThread().getName());
		if (t1.isAlive())
			System.out.println("Thread1 alive");
		if (t2.isAlive())
			System.out.println("Thread2 alive");
		System.out.println(t1.getState().toString());
		System.out.println(t2.getState().toString());
		// }
		t1.join();
		System.out.println(t1.getState().toString());
		t2.join();
		System.out.println(t2.getState().toString());

	}

}
