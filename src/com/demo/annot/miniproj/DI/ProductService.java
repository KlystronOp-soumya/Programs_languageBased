package com.demo.annot.miniproj.DI;

import java.util.List;

public class ProductService {

	private ProductRepository productRepo = new ProductRepository();

	public List<Product> getFinalPriceList(List<Product> products) {

		List<Product> productRecs = productRepo.getPrice(products).orElse(null);

		for (Product product : productRecs) {
			product.setPrice(product.getPrice() * (100 - product.getDiscount()) / 100);

			System.out.println(product);
		}

		return productRecs;
	}
}
