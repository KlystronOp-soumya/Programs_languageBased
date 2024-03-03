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

}
