package com.demo.designpatterns.template;

import java.io.File;
import java.util.Collections;
import java.util.List;

public class CsvDataProcessor<T> extends StructuredDataProcessor<T> {

	private File file;

	public CsvDataProcessor(File file, T lineMap) {
		super(file, lineMap);

	}

	@Override
	protected List<T> lineMapper() {

		return Collections.emptyList();

	}

	@Override
	protected void readData() {

		System.out.println("Reading CSV file");
		file = null;
	}

	@Override
	protected void validateData() {
		System.out.println("Validating CSV file");
		processData();
		saveData();
	}

	@Override
	protected void processData() {
		System.out.println("processing data:: csv");
		lineMapper();
	}

	@Override
	protected void saveData() {
		System.out.println("Saving the data");
	}
}
