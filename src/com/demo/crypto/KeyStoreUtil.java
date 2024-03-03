package com.demo.crypto;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateException;

import javax.crypto.SecretKey;

public class KeyStoreUtil {

	// first get the keystore
	public static KeyStore getKeyStore() throws KeyStoreException {

		System.out.println("Get the keystore");

		KeyStore ks = KeyStore.getInstance("pkcs12");

		return ks;

	}

	public static void storeKeyStore(final KeyStore kStore, char[] password) {
		try (BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream("soumya.jks"))) {
			// first load the keystore
			// here first parameter is null to indicate that we have prepared the ks first
			// the second parameter should not be null
			kStore.load(null, password);
			// then save this into the memory
			kStore.store(fos, password);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public static KeyStore loadKeyStore(char[] password) throws NoSuchAlgorithmException, CertificateException,
			FileNotFoundException, IOException, KeyStoreException {
		KeyStore keyStore = KeyStore.getInstance("JKS");

		keyStore.load(new BufferedInputStream(new FileInputStream("soumya.jks")), password);

		return keyStore;
	}

	// gets the key from the crypto util
	public static void storePassWordInKeyStore(final SecretKey secretKey, final KeyStore ks, final char[] pwdArray)
			throws KeyStoreException {
		KeyStore.SecretKeyEntry secret = new KeyStore.SecretKeyEntry(secretKey);
		KeyStore.ProtectionParameter ksPassword = new KeyStore.PasswordProtection(pwdArray);
		ks.setEntry("db-encryption-secret", secret, ksPassword);
	}

	public static void storePrivateKeyInKeyStore(final SecretKey privateKey, final KeyStore ks, final char[] pwdArray)
			throws NoSuchAlgorithmException, UnrecoverableEntryException, KeyStoreException {
		// Create the password for the keystore
		KeyStore.ProtectionParameter protParam = new KeyStore.PasswordProtection(pwdArray);

		// get my private key from the keystore
		KeyStore.PrivateKeyEntry pkEntry = (KeyStore.PrivateKeyEntry) ks.getEntry("privateKeyAlias", protParam);
		PrivateKey myPrivateKey = pkEntry.getPrivateKey();

		// save my secret key
		// javax.crypto.SecretKey mySecretKey;
		KeyStore.SecretKeyEntry skEntry = new KeyStore.SecretKeyEntry(privateKey);
		ks.setEntry("secretKeyAlias", skEntry, protParam);
	}

	public void deleteEntryFromKeyStore(final KeyStore ks, final String alias) throws KeyStoreException {
		ks.deleteEntry(alias);
	}
}
