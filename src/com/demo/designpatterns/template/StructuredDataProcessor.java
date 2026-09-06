package com.demo.designpatterns.template;

import java.io.File;
import java.util.List;

public abstract class StructuredDataProcessor<T> extends DataProcessor {

	T lineMap;
	File file;

	public StructuredDataProcessor(File file, T lineMap) {
		this.file = file;
		this.lineMap = lineMap;
	}

	@Override
	protected void readData() {

	}

	@Override
	protected void validateData() {

		processData();
		saveData();
	}

	@Override
	protected void processData() {
		System.out.println("Structured processor");
		lineMapper();

	}

	@Override
	protected void saveData() {
		System.out.println("Structured processor");
	}

	protected abstract List<T> lineMapper();

}
