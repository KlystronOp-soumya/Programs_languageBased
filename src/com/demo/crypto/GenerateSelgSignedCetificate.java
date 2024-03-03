package com.demo.crypto;

import java.math.BigInteger;
import java.security.KeyPair;
import java.security.SecureRandom;
//https://www.javatips.net/api/sun.security.x509.certandkeygen
import java.security.cert.X509Certificate;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;

public class GenerateSelgSignedCetificate {

	public static void main(String[] args) {
		try {
			CertAndKeyGen keyGen = new CertAndKeyGen("RSA", "SHA1WithRSA", null);
			keyGen.generate(1024);

			// Generate self signed certificate
			X509Certificate[] chain = new X509Certificate[1];
			chain[0] = keyGen.getSelfCertificate(new X500Name("CN=ROOT"), (long) 365 * 24 * 3600);

			System.out.println("Certificate : " + chain[0].toString());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static Certificate generateCertificate(KeyPair keyPair)
			throws CertificateException, OperatorCreationException {
		X500Name x500Name = new X500Name("CN=***.com, OU=Security&Defense, O=*** Crypto., L=Ottawa, ST=Ontario, C=CA");
		SubjectPublicKeyInfo pubKeyInfo = SubjectPublicKeyInfo.getInstance(keyPair.getPublic().getEncoded());
		final Date start = new Date();
		final Date until = Date
				.from(LocalDate.now().plus(365, ChronoUnit.DAYS).atStartOfDay().toInstant(ZoneOffset.UTC));
		final X509v3CertificateBuilder certificateBuilder = new X509v3CertificateBuilder(x500Name,
				new BigInteger(10, new SecureRandom()), start, until, x500Name, pubKeyInfo);
		ContentSigner contentSigner = new JcaContentSignerBuilder("SHA256WithRSA").build(keyPair.getPrivate());

		Certificate certificate = new JcaX509CertificateConverter().setProvider(new BouncyCastleProvider())
				.getCertificate(certificateBuilder.build(contentSigner));

		System.out.println("x.509 certificate is successfully generated!");

		return certificate;

	}

}
