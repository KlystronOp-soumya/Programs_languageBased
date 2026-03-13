package com.demo.designpatterns.structural.adapter;

import java.math.BigDecimal;
import java.util.List;

public class DatabaseDataGenerator {

	List<DatabaseNew> getData() {

		return List.of(new DatabaseNew(1, BigDecimal.valueOf(1)), new DatabaseNew(2, BigDecimal.valueOf(3)),
				new DatabaseNew(3, BigDecimal.valueOf(5)));
	}
}
