package com.demo.wrapperclass;

import java.util.ArrayList;

public class WrapperClassDemo {

	public static void main(String[] args) {

		char ch = 'S'; // primitive datatype

		// Character Wrapper Class
		Character cha = ch; // autoboxing

		char ch2 = cha;// unboxing

		ArrayList<Integer> arrayList = new ArrayList<>();

		arrayList.add(13);// autoboxing

	}
}
