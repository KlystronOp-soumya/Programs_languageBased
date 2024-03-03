package com.demo.UEMassig;

@SuppressWarnings("unused")
public class CustomStringApi {

	final private char[] xstr;
	private int str_len = 0;

	// Default constructor
	public CustomStringApi() {
		this.xstr = null;

	}

	public CustomStringApi(final char[] str) {
		// TODO Auto-generated constructor stub
		this.xstr = str.clone();
	}

	public char xCharAt(int index) {
		if (index > (this.str_len - 1) || index < 0)
			throw new IndexOutOfBoundsException("Index not found");
		return this.xstr[index];
	}

	public int xLength() {
		if (this.xstr == null)
			return -1;
		else {
			for (char c : this.xstr)
				this.str_len++;
		}
		return this.str_len;
	}

	public char[] xConcat(char[] toConcat) {
		throw new RuntimeException("Immutable Strings can not be concatinated");
	}

	public int xCompareTo(char[] toCompare) {
		return -1;
	}

	public int xIndexOf(char[] subStr) {

		return -1;
	}

}
