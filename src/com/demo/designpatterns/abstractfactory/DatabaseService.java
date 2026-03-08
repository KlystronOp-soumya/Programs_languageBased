package com.demo.designpatterns.abstractfactory;

public class DatabaseService implements Service {

	@Override
	public String createService() {

		return "Database Service";
	}

}
