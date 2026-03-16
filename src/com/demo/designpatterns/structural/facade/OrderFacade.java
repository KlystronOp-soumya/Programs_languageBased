package com.demo.designpatterns.structural.facade;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OrderFacade { // encapsulates other classes which is required to fulfill an order

	private PaymentService paymentService;
	private InventoryService inventoryService;

	void createOrder() {
		paymentService.initiatePayment(0);
		inventoryService.updateInventory("1");
	}

}
