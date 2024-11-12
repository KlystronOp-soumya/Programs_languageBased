package com.demo.json;

import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Properties;

public class WeatherApp {

	public static void main(String[] args) {
		// read the properties file
		ClassLoader classLoader = WeatherApp.class.getClassLoader();

		try (InputStream resourceStream = classLoader.getResourceAsStream("application.properties");) {
			Properties prop = new Properties();
			prop.load(resourceStream);

		} catch (Exception e) {
			OutputStream outputStream = new BufferedOutputStream(System.err);
			PrintWriter out = new PrintWriter(outputStream, true);

			out.println(e.getMessage());
			// out.flush();

		}
	}

}
