package com.demo.annot.miniproj.DI;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product implements Serializable {

	private static final long serialVersionUID = 7175258048729514084L;

	private String name;
	private double discount;
	private double price;

	@Override
	public String toString() {
		return "Product [name=" + name + ", discount=" + discount + ", price=" + price + "]";
	}

}
