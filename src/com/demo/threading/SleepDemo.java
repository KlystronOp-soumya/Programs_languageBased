package com.demo.threading;

public class SleepDemo extends Thread {
	@Override
	public void run() {
		System.out.println("Current Thread: " + Thread.currentThread().getName());
		// TODO Auto-generated method stub
		for (int i = 1; i <= 5; ++i) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			System.out.println(i);
		}

	}

	public static void main(String[] args) {
		SleepDemo obj1 = new SleepDemo();
		SleepDemo obj2Demo = new SleepDemo();

		obj1.setName("Thread1");
		obj2Demo.setName("Thread2");

		obj1.start();
		obj2Demo.start();
	}
}
