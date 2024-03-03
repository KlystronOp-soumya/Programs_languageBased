package com.demo.threading;

public class Multi extends Thread {
	@Override
	public void run() {
		System.out.println("Running thread>>");
		try {
			this.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("After 5 sec ");
	}

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Multi objMulti = new Multi();
		objMulti.start();
		System.out.println(
				"Thread: " + objMulti.getName() + " Id:" + objMulti.getId() + " priority: " + objMulti.getPriority());

		objMulti.join();
		// objMulti.stop();
		System.out.println("Hello");
	}

}
