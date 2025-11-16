package com.demo.FFM;

import java.util.Arrays;

public class Sha256MainApp {

	public static void main(String[] args) {
		CryptoSha256 c = new CryptoSha256();

		byte[] data = "hello".getBytes();
		byte[] hash = null;
		try {
			hash = c.sha256(data);
		} catch (Throwable ex) {

			ex.printStackTrace();
		}

		System.out.println(Arrays.toString(hash));

	}

}
