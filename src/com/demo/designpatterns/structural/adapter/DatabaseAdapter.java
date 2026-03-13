package com.demo.designpatterns.structural.adapter;

import java.util.List;

public interface DatabaseAdapter {

	List<DatabaseLegacy> toDatabaseLegacies(List<DatabaseNew> records);
}
