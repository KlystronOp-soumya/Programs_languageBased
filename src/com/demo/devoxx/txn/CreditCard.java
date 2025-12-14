package com.demo.devoxx.txn;

import java.math.BigDecimal;

import com.demo.LogUtil;

public class CreditCard implements PaymentType {

	private BigDecimal amount;

	public CreditCard(BigDecimal amount) {
		super();
		this.amount = amount;
	}

	private void charge() {
		LogUtil.debug(CreditCard.class, "/* ... details on credit card deductions ...*/");
	}

	@Override
	public void pay() {
		charge();
	}

}
