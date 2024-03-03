package com.demo.crypto;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.ProviderException;
import java.security.spec.EncodedKeySpec;
import java.security.spec.PKCS8EncodedKeySpec;

public class GeneratePrivateKey {

		public static void main(String[] argv) throws Exception 
		{ 
			try { 

				// creating the object of KeyPairGenerator 
				KeyPairGenerator kpg = KeyPairGenerator 
										.getInstance("DSA"); 

				// initializing with 1024 
				kpg.initialize(1024); 

				// getting key pairs 
				// using generateKeyPair() method 
				KeyPair kp = kpg.genKeyPair(); 

				// getting public key 
				PrivateKey prv = kp.getPrivate(); 

				// getting byte data of private key 
				byte[]  KeyBytes = prv.getEncoded(); 

				// creating keyspec object 
				EncodedKeySpec 
					 KeySpec 
					= new PKCS8EncodedKeySpec( KeyBytes); 

				// creating object of keyfactory 
				KeyFactory keyFactory = KeyFactory.getInstance("DSA"); 

				// generating private key from the provided key spec. 
				// using generatePrivate() method 
				PrivateKey  Key = keyFactory 
											.generatePrivate( KeySpec); 

				// printing private key 
				System.out.println("PrivateKey : " +  Key); 
			} 

			catch (NoSuchAlgorithmException e) { 

				System.out.println("Exception thrown : " + e); 
			} 
			catch (ProviderException e) { 

				System.out.println("Exception thrown : " + e); 
			} 
		} 
	 

	
}
