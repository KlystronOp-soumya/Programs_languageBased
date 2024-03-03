package com.demo.crypto;

import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Base64;
import java.util.Date;

import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.X509Name;
import org.bouncycastle.x509.X509V3CertificateGenerator;

public class KeyPairUtil {
	
	private static final String PASSWORD_KS = "s13608" ;
	public static void main(String[] args) {
		System.out.println("Generating the Key Pair- Public and a Private key");
		KeyPairGenerator keyPairGenerator;
		try {
			keyPairGenerator = KeyPairGenerator.getInstance("RSA");
			//specify the size
			keyPairGenerator.initialize(2048);
			KeyPair keyPair = keyPairGenerator.generateKeyPair() ;
			
			Provider pd = keyPairGenerator.getProvider() ;
			String algoString = keyPairGenerator.getAlgorithm() ;
			
			System.out.println("Provider: " + pd.getName() + " algorithm: " + algoString);
			
			//generate keystore
			System.out.println("Generating key store");
			KeyStore kStore = KeyStore.getInstance("JKS") ;
			kStore.load(null, PASSWORD_KS.toCharArray());
			
			byte publicKey[] = keyPair.getPublic().toString().getBytes("UTF-8") ;
			byte privateKey[] = keyPair.getPrivate().toString().getBytes() ;
			System.out.println("Showing the public key: " + Base64.getEncoder().encodeToString(publicKey));
			System.out.println("Showing the private key: " + Base64.getEncoder().encodeToString(privateKey));
			System.out.println("Storing the private key into the key store");
			kStore.setKeyEntry("privkey", keyPair.getPrivate(),PASSWORD_KS.toCharArray() , new Certificate[] {getCertificate(keyPair.getPublic(), keyPair.getPrivate())}  ) ;
			try(FileOutputStream fos = new FileOutputStream("mykeystore.keystore")) {
				
				kStore.store(fos , PASSWORD_KS.toCharArray());
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KeyStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CertificateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalStateException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SignatureException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}
	
	@SuppressWarnings("deprecation")
	private static Certificate getCertificate(final PublicKey publicKey , final PrivateKey privateKey) throws CertificateEncodingException, InvalidKeyException, IllegalStateException, NoSuchAlgorithmException, SignatureException
	{
		Date validityBeginDate = new Date() ;
		Date validityEndDate = new Date(validityBeginDate.getDay() + 365) ;
		
		//set the certificate issuer
		X509Name issuer = new X509Name("CN=SelfSigned Certificate-Soumya") ;
		X509Name subject = issuer ;
		
		//Create a Certificate serial number
		BigInteger serialNumber = BigInteger.valueOf(System.currentTimeMillis()) ;
		
		//generate the certificate
		X509V3CertificateGenerator certificateGenerator = new X509V3CertificateGenerator() ;
		certificateGenerator.setSerialNumber(serialNumber);
		certificateGenerator.setIssuerDN(issuer);
		certificateGenerator.setNotBefore(validityBeginDate);
		certificateGenerator.setNotAfter(validityEndDate);
		certificateGenerator.setSubjectDN(subject);
		certificateGenerator.setPublicKey(publicKey);
		certificateGenerator.setSignatureAlgorithm("SHA256WITHRSA");
		
		X509Certificate certificate = certificateGenerator.generate(privateKey) ;
		
		return certificate ;

	}
	
	
}
