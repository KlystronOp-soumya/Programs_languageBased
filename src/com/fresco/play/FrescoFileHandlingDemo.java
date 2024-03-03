package com.fresco.play;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class EncryptDecryptFile {

	public static void createFile() throws IOException {

		String fileNameString = FrescoFileHandlingDemo.finalpath + "EncryptedText.txt";
		File file = new File(fileNameString);

		if (!file.exists()) {
			file.createNewFile();
			System.out.println("File: " + file.getName() + " was created.." + file.getAbsolutePath());
		} else {
			System.out.println("Exists");
		}

		// write into this file
		try (FileWriter fWriter = new FileWriter(file); BufferedWriter bWriter = new BufferedWriter(fWriter);) {
			String contentString = "Hello World!!!";

			bWriter.write(contentString);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

	}

	public static void cleanup() {
		File finFile = new File(FrescoFileHandlingDemo.finalpath + "EncryptedText.txt");
		File outFile = new File(FrescoFileHandlingDemo.finalpath + "DecryptionFile.txt");

		if (finFile.exists() && outFile.exists()) {
			finFile.delete();
			outFile.delete();
		}
		if (!(finFile.exists()) && !(outFile.exists())) {
			System.out.println("Deleted Successfully");
		}
	}

	// function to read the contents of the file
	public String readEncryptionFile() throws IOException {
		String fileNameString = FrescoFileHandlingDemo.finalpath + "EncryptedText.txt";
		String contentString, retString = null;
		try (FileReader fileReader = new FileReader(new File(fileNameString));
				BufferedReader bufferedReader = new BufferedReader(fileReader);) {

			while ((contentString = bufferedReader.readLine()) != null) {
				retString = contentString;
				System.out.println("EncryptedMessage is:\n " + contentString);
			}
		}

		return (retString != null) ? retString : null;

	}

	public void writeDecryptionFile(String message) throws IOException {
		String outputPathString = FrescoFileHandlingDemo.finalpath + "DecryptionFile.txt";

		File file = new File(outputPathString);
		if (file.exists()) {
			System.out.println("File: " + file.getName() + " exists");
		} else {
			System.out.println("File: " + file.getName() + " not file");
		}
		try (FileWriter fWriter = new FileWriter(file, true);
				BufferedWriter bufferedWriter = new BufferedWriter(fWriter);) {
			bufferedWriter.write(message);
		}
		if (file.exists()) {
			System.out.println("File created: " + file.getName() + " at: " + file.getAbsolutePath());
		}
	}

}

public class FrescoFileHandlingDemo {
	public static final String finalpath = "D:\\Program Files\\Java Programs\\JavaDemos\\";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			EncryptDecryptFile.createFile();
			EncryptDecryptFile objEncryptDecryptFile = new EncryptDecryptFile();
			String messageString = objEncryptDecryptFile.readEncryptionFile();
			System.out.println("Returned: " + messageString);
			if (messageString != null)
				objEncryptDecryptFile.writeDecryptionFile(messageString);
			else {
				System.err.println("op File not crerated");
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
		}
	}

}
