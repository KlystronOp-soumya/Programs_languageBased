package com.demo.designpatterns.creational.builder;

public class ApartmentBuilder {

	private String address = null;
	private int floor = -1;
	private int rooms = -1;
	private boolean hasBalcony = false;
	private boolean hasKitchen = false;

	// add the fluent setters
	public ApartmentBuilder withAddress(String address) {
		this.address = address;
		return this;
	}

	public ApartmentBuilder withFloor(int floor) {
		this.floor = floor;
		return this;
	}

	public ApartmentBuilder withRooms(int rooms) {
		this.rooms = rooms;
		return this;
	}

	public ApartmentBuilder withKitchen(boolean hasKitchen) {
		this.hasKitchen = hasKitchen;
		return this;
	}

	public ApartmentBuilder withBalcony(boolean hasBalcony) {
		this.hasBalcony = hasBalcony;
		return this;
	}

	public Apartment build() {

		Apartment ap = new Apartment(this);
		return ap;
	}

	public String getAddress() {
		return this.address;
	}

	public int getFloor() {
		return this.floor;
	}

	public int getRooms() {
		return this.rooms;
	}

	public boolean isHasBalcony() {
		return this.hasBalcony;
	}

	public boolean isHasKitchen() {
		return this.hasKitchen;
	}

}
