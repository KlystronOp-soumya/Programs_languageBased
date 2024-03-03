package com.fresco.play;

//Parent class

class Parent {
	public int startElement, endElement;

	public Parent(int a, int b) {
		// TODO Auto-generated constructor stub
		startElement = a;
		endElement = b;
	}

	public String filter() {
		return null;
	}
}

//returns all the primes in a range
class ChildOne extends Parent {

	int minL, maxL;
	boolean flag = true;

	public ChildOne(int a, int b) {
		super(a, b);
		// TODO Auto-generated constructor stub
		minL = super.startElement;
		maxL = super.endElement;
	}

	@Override
	public String filter() {

		String resultString = "";

		for (int i = minL; i <= maxL; ++i) {
			// outer loop
			if (i == 1)
				continue;

			for (int j = 2; j <= i / 2; ++j) {
				// inner loop
				if (i % j == 0) {
					flag = false;
					break;
				}
			}
			if (flag) {
				// System.out.println("Prime: " + i);
				resultString += Integer.toString(i) + " ";
				// reset the flag
			}
			// flag reset
			flag = true;

		}

		return resultString.trim();

	}

}

//returns the happy numbers

class ChildTwo extends Parent {

	// int minL, maxL;

	public ChildTwo(int a, int b) {
		super(a, b);
	}

	// recursive program
	private int isHappy(int n) {
		int sum = 0, temp;
		temp = n;
		if (n == 1) {
			// System.out.println("Current: " + n + " next: " + sum);

			return 1;// happy
		}

		if (n == 4) {
			// System.out.println("Current: " + n + " next: " + sum);
			return 0;// unhappy
		}

		while (temp != 0) {
			int rem = temp % 10;
			sum += (int) Math.pow(rem, 2);
			temp = temp / 10;
		}
		// System.out.println("Current: " + n + " next: " + sum);
		return isHappy(sum);
	}

	@Override
	public String filter() {
		String resultString = "";
		for (int i = super.startElement; i <= super.endElement; ++i) {
			if (isHappy(i) == 1) {
				resultString += Integer.toString(i) + " ";
			}
		}
		return resultString.trim();
		// to return happy number string }

	}
}

public class FrescoPolymorphismSolution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChildOne objChildOne = new ChildOne(1, 150);
		ChildTwo objChildTwo = new ChildTwo(1, 150);

		// System.out.println("DISPLAYING RESULT:");
		System.out.println(objChildOne.filter());
		System.out.println(objChildTwo.filter());

	}
}
