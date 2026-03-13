package com.demo.designpatterns.structural.adapter;

import java.math.BigDecimal;

//Target interface application uses
public interface PaymentProcessor {

	void pay(BigDecimal amount);
}
