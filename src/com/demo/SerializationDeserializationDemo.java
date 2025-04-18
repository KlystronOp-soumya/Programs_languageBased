package com.demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Demo implements Serializable {

	private static final long serialVersionUID = 1L;

	int a, b;

	public Demo(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}

}

public class SerializationDeserializationDemo {

	public static void main(String[] args) {

		Demo obj = new Demo(1, 2);
		String fileName = "data.dat";
		try (FileOutputStream fileOutputStream = new FileOutputStream(fileName);
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);) {

			objectOutputStream.writeObject(obj);

		} catch (Exception e) {
			e.printStackTrace();
		}

		try (FileInputStream in = new FileInputStream(fileName); ObjectInputStream inObj = new ObjectInputStream(in);) {
			Demo obj1 = (Demo) inObj.readObject();

			System.out.println(obj1.a);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
