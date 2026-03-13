package com.demo.designpatterns.structural.adapter;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PaypalAdapter implements PaymentProcessor {

	private PaypalGateway paypalGateway;

	@Override
	public void pay(BigDecimal amount) { // the application uses this method

		paypalGateway.makePayment(amount.doubleValue()); // but the third party jar gives this one and we need to
															// integrate; this mostly been used for legacy integration

	}

}
