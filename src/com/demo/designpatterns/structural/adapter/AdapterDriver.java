package com.demo.designpatterns.structural.adapter;

import java.math.BigDecimal;

public class AdapterDriver {

	public static void main(String[] args) {

		PaymentProcessor paymentProcessor = new PaypalAdapter(new PaypalGateway());

		paymentProcessor.pay(BigDecimal.valueOf(10));
	}

}
