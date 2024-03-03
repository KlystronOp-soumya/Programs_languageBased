package com.demo.threading;

public class Multi3 implements Runnable {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("thread is running...");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runnable r1 = new Multi3();
		r1.run();
		/*
		 * If you are not extending the Thread class,your class object would not be
		 * treated as a thread object.So you need to explicitely create Thread class
		 * object.We are passing the object of your class that implements Runnable so
		 * that your class run() method may execute. Multi3 m1=new Multi3(); Thread
		 * t1=new Thread(m1); t1.start();
		 */
	}

}
