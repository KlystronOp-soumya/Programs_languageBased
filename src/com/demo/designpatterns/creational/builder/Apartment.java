package com.demo.designpatterns.creational.builder;

public class Apartment {
	private String address;
	private int floor;
	private int rooms;
	private boolean hasBalcony;

	public Apartment(ApartmentBuilder builder) {
		this.address = builder.getAddress();
		this.floor = builder.getFloor();
		this.rooms = builder.getRooms();
		this.hasBalcony = builder.isHasBalcony();
	}

	@Override
	public String toString() {
		return "Apartment at " + address + ", Floor: " + floor + ", Rooms: " + rooms + ", Balcony: " + hasBalcony;
	}

}
