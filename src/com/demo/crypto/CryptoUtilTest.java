package com.demo.crypto;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.UUID;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CryptoUtilTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void whenKeyGenerated_checkEncryption_test() throws NoSuchAlgorithmException, InvalidKeyException,
			NoSuchPaddingException, InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException {
		String input = "baeldung";
		SecretKey key = CryptoUtil.generateKey(128);
		IvParameterSpec ivParameterSpec = CryptoUtil.generateIv();
		String algorithm = "AES/CBC/PKCS5Padding";

		String cipherText;

		cipherText = CryptoUtil.encrypt(algorithm, input, key, ivParameterSpec);
		String plainText = CryptoUtil.decrypt(algorithm, cipherText, key, ivParameterSpec);
		Assert.assertEquals("Decrypted text is not matching", "baeldung", plainText);
	}

	@Test
	public void whenKeyGeneratedFrmPassword_checkEncryption_test()
			throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, NoSuchPaddingException,
			InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException {
		String input = "baeldung";
		String salt = String.valueOf(UUID.randomUUID());
		SecretKey key = CryptoUtil.getKeyFromPassword(input, salt);
		IvParameterSpec ivParameterSpec = CryptoUtil.generateIv();
		String algorithm = "AES/CBC/PKCS5Padding";
		String cipherText;

		cipherText = CryptoUtil.encrypt(algorithm, input, key, ivParameterSpec);
		String plainText = CryptoUtil.decrypt(algorithm, cipherText, key, ivParameterSpec);
		Assert.assertEquals("Decrypted text is not matching", "baeldung", plainText);
	}

}
