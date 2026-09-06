package com.demo.tests.designpatterns;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.problems.ProductCode;

class ProductCodeTests {

	@Test
	void testProductCodesAreNotEmpty() {

		ProductCode[] productCode = ProductCode.values();

		assertEquals(5, productCode.length);
	}

	@Test
	void testProductCodeWithProductMapIsNotEmpty() {

		Map<String, ProductCode> productCodeWithProductMap = ProductCode.productCodeWithProduct;

		assertTrue(CollectionUtils.isNotEmpty(productCodeWithProductMap.keySet()));
	}

	@ParameterizedTest
	@CsvSource({ "PROD_1", "PROD-1", "PROD_2", "PROD-2", "PROD_3", "PRO  D-3", "PROD_13", "PROD-13", "PROD_10",
			"PROD-10" })
	void testAllProductCodesArePresent(String product, String productCode) {

		Map<String, ProductCode> productCodeWithProductMap = ProductCode.productCodeWithProduct;

		assertTrue(productCodeWithProductMap.get(productCode).name().equals(product));
	}
}
