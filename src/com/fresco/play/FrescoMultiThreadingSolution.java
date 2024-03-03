package com.fresco.play;

import java.util.Scanner;
/*
class Task1 extends Thread {
	static int a, beg;// 80 0

	@Override
	public void run() {
		// TODO Auto-generated method stub
		// beg=0 to a-1
		int i = 0;
		// System.out.println("Initially In Task1 a=" + a + " beg=" + beg);
		while (i < a) {// 0-79
			FrescoMultiThreadingSolution.threadArray[i] = i;
			i++;
		}
		// System.out.println("In Task1 a=" + a + " beg=" + beg);
		// 80 80
	}

}

class Task2 implements Runnable {
	static int a, beg;// 130 80

	@Override
	public void run() {
		int i = Task1.a;
		// TODO Auto-generated method stub
		// beg=one
		// System.out.println("Initially In Task2 a=" + a + " beg=" + beg);
		while (i < (Task1.a + Task2.a)) {
			FrescoMultiThreadingSolution.threadArray[i] = i;
			// ++beg;
			++i;
		}
		// System.out.println("In Task2 a=" + a + " beg=" + beg);
	}
}

class Task3 implements Runnable {
	static int a, beg;// 90 210

	@Override
	public void run() {
		int i = Task1.a + Task2.a;
		// TODO Auto-generated method stub
		// System.out.println("Initially In Task3 a=" + a + " beg=" + beg);
		while (i < 300) {
			FrescoMultiThreadingSolution.threadArray[i] = i;
			++i;

		}
		// System.out.println("In Task3 a=" + a + " beg=" + beg);
		// beg = Task1.a + Task2.a;
	}
}


*/

class Task1 extends Thread {
	static int a = 0;
	static int beg = 0;

	public void run() {
		for (int i = beg; i < a; i++)
			FrescoMultiThreadingSolution.threadArray[i] = i;
	}
}

class Task2 extends Thread {
	static int a = 0;
	static int beg = 0;

	public void run() {
		for (int i = beg; i < beg + a; i++)
			FrescoMultiThreadingSolution.threadArray[i] = i;
	}
}

class Task3 extends Thread {
	static int a = 0;
	static int beg = 0;

	public void run() {
		for (int i = beg; i < a + beg; i++)
			FrescoMultiThreadingSolution.threadArray[i] = i;
	}
}

public class FrescoMultiThreadingSolution {
	public static final int[] threadArray = new int[300];
	public static volatile String i = 0 + "";

	public boolean test() throws InterruptedException {
		Task1 task1 = new Task1();
		Task2 task2 = new Task2();
		Task3 task3 = new Task3();
		Thread task2Thread = new Thread(task2);
		Thread task3Thread = new Thread(task3);
		task1.start();
		task2Thread.start();
		task3Thread.start();
		task1.join();
		task2Thread.join();

		int first = Task1.a + Task2.a;
		int containsSecondThread = Task1.a;
		String oneAndTwo = "";
		String sizeOfTask1 = "";
		for (int i = 0; i < first; i++) {
			oneAndTwo += threadArray[i] + " ";
		}
		//// System.out.println("OneAndTwo: " + oneAndTwo);

		for (int i = 0; i < containsSecondThread; i++) {
			sizeOfTask1 += threadArray[i] + " ";
		}

		// System.out.println("sizeOfTask1: " + sizeOfTask1);
		int begOfTask3 = Task3.beg;
		// System.out.println("begOfTask3: " + begOfTask3);
		String checkingString = "";
		for (int i = begOfTask3; i < threadArray.length; i++) {
			checkingString += i + " ";
		}

		// System.out.println("CheckString: " + checkingString);

		String task3String = "";
		for (int j = begOfTask3; j < threadArray.length; j++) {
			task3String += threadArray[j] + " ";
		}

		// System.out.println("task3String: " + task3String);
		// System.out.println("Length of thread array: " + threadArray.length);
		// System.out.println("Task2 begining: " + Task2.beg);
		if ((!oneAndTwo.contains(begOfTask3 + "") && sizeOfTask1.contains(Task2.beg + ""))
				&& task3String.equals(checkingString)) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner sc = new Scanner(System.in);
			FrescoMultiThreadingSolution solution = new FrescoMultiThreadingSolution();
			int one = sc.nextInt();
			Task1.a = one;// number of elements to be inserted
			Task1.beg = 0;
			int two = sc.nextInt();
			Task2.a = two;
			Task2.beg = one;// i
			int three = sc.nextInt();
			Task3.a = three;
			Task3.beg = one + two;
			System.out.print(solution.test());
			sc.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
