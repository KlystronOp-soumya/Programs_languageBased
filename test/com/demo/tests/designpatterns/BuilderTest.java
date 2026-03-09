package com.demo.tests.designpatterns;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;

import com.demo.designpatterns.builder.Apartment;
import com.demo.designpatterns.builder.ApartmentBuilder;
import com.demo.designpatterns.builder.MultiDBDatasource;

public class BuilderTest {

	@Test
	void testMultiDBBuilder() {

		MultiDBDatasource datasource = MultiDBDatasource.builder().connectionString("connectionString")
				.databaseUrl("databaseUrl").username("username").password("password").build();

		assertNotNull(datasource);

	}

	@Test
	void testApartmentBuilder() {

		ApartmentBuilder apartmentBuilder = new ApartmentBuilder().withFloor(2).withBalcony(true).withKitchen(true)
				.withRooms(3);

		Apartment apartment = apartmentBuilder.build();

		assertNotNull(apartment);
	}

}
