package com.problems;

class ThreadDem1 implements Runnable {

	@Override
	public void run() {

		try {
			for (int i = 1; i <= 5; i++) {
				System.out.println("T1:: i-> " + i);
				Thread.sleep(5000);
			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class ThreadDem2 implements Runnable {

	@Override
	public void run() {

		try {

			for (int i = 1; i <= 5; i++) {
				System.out.println("T2:: i-> " + i);
				Thread.sleep(5000);
			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
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

		t1.start();

		t2.start();

		// while (t1.isAlive() || t2.isAlive()) {

		System.out.println("Current Thread name: " + Thread.currentThread().getName());
		if (t1.isAlive())
			System.out.println("Thread1 alive");
		if (t2.isAlive())
			System.out.println("Thread2 alive");

		// }
		t1.join();
		t2.join();

	}

}
