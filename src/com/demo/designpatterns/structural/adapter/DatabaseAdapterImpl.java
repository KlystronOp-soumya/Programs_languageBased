package com.demo.designpatterns.structural.adapter;

import java.util.ArrayList;
import java.util.List;

public class DatabaseAdapterImpl implements DatabaseAdapter {

	@Override
	public List<DatabaseLegacy> toDatabaseLegacies(List<DatabaseNew> records) {

		List<DatabaseLegacy> databaseLegacies = new ArrayList<>();

		for (DatabaseNew data : records) {

			databaseLegacies.add(new DatabaseLegacy(data.position, data.toString()));

		}

		return databaseLegacies;
	}

}
