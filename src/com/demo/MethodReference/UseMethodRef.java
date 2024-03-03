package com.demo.MethodReference;

import java.util.ArrayList;
import java.util.Collections;

class MyClass {
	private int val;

	MyClass(int v) {
		this.val = v;
	}

	public int getVal() {
		return this.val;
	}
}

public class UseMethodRef {
	static int compareMC(MyClass obj1, MyClass obj2) {
		return obj1.getVal() - obj2.getVal();
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<MyClass> arrayList = new ArrayList<>();
		arrayList.add(new MyClass(3));
		arrayList.add(new MyClass(13));
		arrayList.add(new MyClass(23));
		arrayList.add(new MyClass(33));
		arrayList.add(new MyClass(108));
		arrayList.add(new MyClass(666));

		MyClass maxValObjClass = Collections.max(arrayList, UseMethodRef::compareMC);
	}

}
