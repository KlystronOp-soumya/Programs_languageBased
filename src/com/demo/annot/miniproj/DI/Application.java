package com.demo.annot.miniproj.DI;

import java.util.ArrayList;
import java.util.List;

public class Application {

	public static void main(String[] args) {
		run(args);
	}

	private static void run(String[] args) {

		ApplicationContext context = new ApplicationContext(AppConfig.class);

		ProductService productService = (ProductService) context.getBean(ProductService.class);

		List<Product> products = new ArrayList<>();

	}
}
