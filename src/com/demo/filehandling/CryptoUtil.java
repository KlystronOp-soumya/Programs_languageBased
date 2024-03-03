package com.demo.filehandling;

public class CryptoUtil implements Cryptography {

	protected static int shift_val = 4;

	static {
		shift_val = shift_val % 26;
	}

	public CryptoUtil() {
		// TODO Auto-generated constructor stub
	}

	private StringBuffer doEncryption(final String actualFileContent) {
		StringBuffer result = new StringBuffer();
		char ch;
		for (int i = 0; i < actualFileContent.length(); i++) {
			if ((ch = actualFileContent.charAt(i)) == ' ') {
				result.append(ch);
			} else if (Character.isUpperCase(actualFileContent.charAt(i))) {
				ch = (char) (((int) actualFileContent.charAt(i) + shift_val - 65) % 26 + 65);
				result.append(ch);
			} else {
				ch = (char) (((int) actualFileContent.charAt(i) + shift_val - 97) % 26 + 97);
				result.append(ch);
			}
		}
		return result;
	}

	private StringBuffer doDecryption(final String cipheredText) {
		StringBuffer result = new StringBuffer();

		for (int i = 0; i < cipheredText.length(); i++) {
			if (Character.isUpperCase(cipheredText.charAt(i))) {
				char ch = (char) (((int) cipheredText.charAt(i) + (26 - shift_val) - 65) % 26 + 65);
				result.append(ch);
			} else {
				char ch = (char) (((int) cipheredText.charAt(i) + (26 - shift_val) - 97) % 26 + 97);
				result.append(ch);
			}
		}
		return result;
	}

	@Override
	public StringBuffer encryptString(final String actualFileContent) {
		// TODO Auto-generated method stub
		return this.doEncryption(actualFileContent);
	}

	@Override
	public StringBuffer decryptString(final String cipheredText) {
		// TODO Auto-generated method stub
		return this.doDecryption(cipheredText);
	}

}
