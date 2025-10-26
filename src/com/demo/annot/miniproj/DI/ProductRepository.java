package com.demo.annot.miniproj.DI;

import java.util.List;
import java.util.Optional;

import com.demo.annot.miniproj.DI.annotation.Component;

@Component
public class ProductRepository {

	public Optional<List<Product>> getPrice(List<Product> products) {

		for (Product product : products) {
			double price = (double) Math.round(30 * Math.random());
			product.setPrice(price);
		}

		return Optional.of(products);
	}

}
