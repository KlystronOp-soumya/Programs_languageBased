package com.demo.threading;

public class ThreadJoinDemo extends Thread {
	@Override
	public void run() {
		System.out.println("Current Thread: " + Thread.currentThread().getName());
		// TODO Auto-generated method stub
		for (int i = 1; i <= 5; i++) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				System.out.println(e);
			}
			System.out.println(i);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadJoinDemo obj1 = new ThreadJoinDemo();
		ThreadJoinDemo obj2 = new ThreadJoinDemo();
		ThreadJoinDemo obj3 = new ThreadJoinDemo();

		obj1.start();
		obj2.start();
		obj3.start();

		try {
			obj1.join();
			obj2.join();
			obj3.join();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private static void joinThread() {
		Runnable task = () -> {
			System.out.println(Thread.currentThread().getName() + " started");
			try {
				Thread.sleep(2000); // simulate work
			} catch (InterruptedException e) {
				System.out.println(Thread.currentThread().getName() + " interrupted");
			}
			System.out.println(Thread.currentThread().getName() + " finished");
		};

		Thread t1 = new Thread(task, "Worker-1");
		Thread t2 = new Thread(task, "Worker-2");

		t1.start();
		t2.start();

		System.out.println("Main thread finished, but workers may still run...");
		System.out.println("Active threads: " + Thread.activeCount());

		// or change them into daemon thread as it will stop when main thread is
		// finished
	}

}
