package com.demo.devoxx.client;

import java.math.BigDecimal;

import com.demo.LogUtil;
import com.demo.devoxx.txn.BankPayment;
import com.demo.devoxx.txn.CreditCard;
import com.demo.devoxx.txn.PaymentType;

/**
 * A simple class that simulates the processing of order using different payment
 * method
 * 
 * 
 */
public class OrderProcessor {

	/*
	 * In the below method we have used concrete class, which violates the OCP
	 * design pattern principle
	 * 
	 */
	/*
	 * public void processOrder(CreditCard creditCard) {
	 * 
	 * creditCard.charge(BigDecimal.valueOf(5000.15D)); }
	 */

	public void processOrder(PaymentType paymentType) {
		/*
		 * Now that here we have used an interface hence our classes follow the OCP rule
		 */

		LogUtil.info(OrderProcessor.class, "Processing order started");
		paymentType.pay();
	}

	public static void main(String[] args) {

		var orderProcessor = new OrderProcessor();

		orderProcessor.processOrder(new CreditCard(BigDecimal.valueOf(5000)));
		orderProcessor.processOrder(new BankPayment(BigDecimal.valueOf(10000)));

	}

}
