package com.demo.filehandling;

public interface Cryptography {

	StringBuffer encryptString(String actualFileContent);

	StringBuffer decryptString(String cipheredText);
}
