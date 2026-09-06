package com.demo.designpatterns.template;

public abstract class DataProcessor {

	public final void process() {

		readData();
		validateData();
		// processData();
		// saveData();
	}

	protected abstract void readData();

	protected abstract void validateData();

	protected abstract void processData();

	protected abstract void saveData();

}
