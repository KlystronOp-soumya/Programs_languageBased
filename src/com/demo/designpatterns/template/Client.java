package com.demo.designpatterns.template;

import java.io.File;

public class Client {

	public static void main(String[] args) {

		StructuredDataProcessor<StudentMapper> dataProcessor = new CsvDataProcessor<StudentMapper>(new File(""),
				new StudentMapper());
		dataProcessor.process();
	}

}
