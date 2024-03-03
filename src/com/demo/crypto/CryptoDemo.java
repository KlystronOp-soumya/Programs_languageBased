package com.demo.crypto;

import java.io.PrintWriter;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class CryptoDemo {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		// TODO Auto-generated method stub
		PrintWriter writer = new PrintWriter(System.out, false);
		String input = "baeldung";
		SecretKey key = CryptoUtil.generateKey(128);
		IvParameterSpec ivParameterSpec = CryptoUtil.generateIv();
		String algorithm = "AES/CBC/PKCS5Padding";
		try {
			String cipherText;

			cipherText = CryptoUtil.encrypt(algorithm, input, key, ivParameterSpec);
			String plainText = CryptoUtil.decrypt(algorithm, cipherText, key, ivParameterSpec);
			writer.write(plainText);
		} catch (InvalidKeyException | NoSuchPaddingException | NoSuchAlgorithmException
				| InvalidAlgorithmParameterException | BadPaddingException | IllegalBlockSizeException e) {
			
			e.printStackTrace();
		} finally {
			writer.close();
		}

	}

}
