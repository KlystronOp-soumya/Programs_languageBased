package com.demo;

public class Test {

	int a, b;

	public Test() {
		super();
	}

	public Test(int i, int j) {
		// TODO Auto-generated constructor stub

		this.a = i;
		this.b = j;
	}

	void callByVal(int i, int j) {
		i *= 2;
		j += 2;
	}

	void callByRef(Test obj) {

		obj.a *= 2;
		obj.b += 2;
	}

	int fact(int i) {
		if (i == 1) {
			return 1;
		}
		return fact(i - 1) * i;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello world");
		/*
		 * System.out.println("Integer:" + Integer.SIZE + "Bits" + Integer.MIN_VALUE);//
		 * in bits System.out.println("Integer:" + Integer.SIZE / 8 + "Bytes" +
		 * Integer.MAX_VALUE);
		 */
		ManagerJunior jrMan1 = new ManagerJunior();
		System.out.println(jrMan1.finAcc);
		jrMan1.checkAllowance();

		ManagerJunior jrMan2 = new ManagerJunior("NA", "A", "A", "NA", "A");
		System.out.println(jrMan2.finAcc);
		jrMan2.checkAllowance();

		Test test = new Test();
		int i = 10, j = 20;
		System.out.println("Value before::\n i:" + i + " j:" + j);
		test.callByVal(i, j);
		System.out.println("Value after::\n i:" + i + " j:" + j);

		Test test2 = new Test();
		test2.a = 20;
		test2.b = 30;
		System.out.println("Value before::\n a:" + test2.a + " b:" + test2.b);
		test2.callByRef(test2);
		System.out.println("Value after::\n a:" + test2.a + " b:" + test2.b);

		Test obj1 = new Test();
		obj1.a = 100;
		obj1.fact(5);
	}

}
