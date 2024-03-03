package com.demo.dao;

import java.util.List;

public interface Dao<T, R> {
//save method to add the objects
	boolean saveEntry(List<T> t); // generic

//display all
	List<T> getAll();
//display a partiuclar record

	T getByAttribute(R r);// accepts particular type

//Update
	boolean updateAttribute(R r);

//delete
	boolean deleteEntry(R r);

}
