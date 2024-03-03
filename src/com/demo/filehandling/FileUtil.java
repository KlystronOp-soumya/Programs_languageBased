package com.demo.filehandling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class FileUtil {
	private static BufferedReader adConsole;
	private static String fileName;
	private static PrintWriter out;
	private static File file;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String readCntent = null;
		try {
			adConsole = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter the file name/path: ");
			fileName = adConsole.readLine();

			file = new File(fileName);
			// check if the file exists
			if (!file.exists()) {
				System.out.println("File is not present..Creating file...");
				file.createNewFile();
				Thread.sleep(1000);
				System.out.println("File created....");
				writeContentIntoFile();
			} else {// file exists

				System.out.println("File is  present..Reading file...");
				readCntent = readFileContent();
				if (!readCntent.isEmpty())
					System.out.println(readCntent);
				else {
					throw new IOException("File is Empty...");
				}
			}

			System.out.println("Do you want to encrypt the file?(E/D/N)");
			char ch = (char) adConsole.read();
			switch (ch) {
			case 'E':
				// do encryption
				break;
			case 'D':
				// do decryption
				break;
			case 'N':
				break;
			default:
				System.exit(-1);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (null != adConsole)
				adConsole.close();
			if (out != null)
				out.close();

			// file.deleteOnExit();
		}
	}

	private static void writeContentIntoFile() throws IOException, InterruptedException {
		String content = null;

		System.out.println("Type the content to write into file::\n\n");
		content = adConsole.readLine();
		out = new PrintWriter(new FileOutputStream(file, true));
		out.write(content);
		out.close();

		System.out.println("File writing completed...");
		Thread.sleep(500);
	}

	private static String readFileContent() {
		StringBuilder readContent = new StringBuilder();
		try (BufferedReader fileBufReader = new BufferedReader(new FileReader(file));) {
			int ch;
			while ((ch = fileBufReader.read()) != -1) {
				readContent.append((char) ch);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return (null == readContent) ? null : readContent.toString();
	}

	public void foo() throws IOException, InterruptedException {
		writeContentIntoFile();
	}

}
