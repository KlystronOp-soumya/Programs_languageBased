package com.demo.threading;

class MultiTask1 extends Thread {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Current Thread: " + Thread.currentThread().getName());
		System.out.println("Performing task 1");
		for (int i = 1; i <= 5; ++i) {
			System.out.println(i);
		}
	}
}

class MultiTask2 extends Thread {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Current Thead: " + Thread.currentThread().getName());
		System.out.println("Performing task 2");
		for (int i = 11; i <= 15; ++i) {
			System.out.println(i);
		}
	}
}

public class MultiTaskDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MultiTask1 objMultiTask1 = new MultiTask1();
		MultiTask2 objMultiTask2 = new MultiTask2();

		try {
			objMultiTask1.start();

			objMultiTask2.start();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
