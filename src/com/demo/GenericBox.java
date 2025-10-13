package com.demo;

public class GenericBox<@NonEmpty T> {

	@NonEmpty
	T size;

	public GenericBox(@NonEmpty T size) {
		this.size = size;
	}

	class NestedBox<@NonEmpty T> {

		void display() {
			System.out.println("Box size " + size);
		}
	}

}
