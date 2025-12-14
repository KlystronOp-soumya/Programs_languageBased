package com.demo.devoxx.txn;

import java.math.BigDecimal;
import java.util.function.Predicate;

import com.demo.LogUtil;

public class BankPayment implements PaymentType {

	private BigDecimal amount;
	private BankingPaymentModes bankPaymentMode;

	public BankPayment(BigDecimal amount) {
		super();
		this.amount = amount;
	}

	public enum BankingPaymentModes {

		BHIM(prefix -> prefix.contains("UPI")), NET_BANKING(prefix -> prefix.contains("NB-")),

		WALLET(prefix -> prefix.contains("-WALLET"));

		private final Predicate<String> validator;

		private BankingPaymentModes(Predicate<String> validator) {
			this.validator = validator;
		}

		public boolean isValid(String prefix) {
			return this.validator.test(prefix);
		}

	}

	void charge() {
		LogUtil.debug(BankPayment.class, "/* ... details on banck deductions ...*/");
	}

	// Fluent setter for enum
	public BankPayment bankPaymentModes(BankingPaymentModes mode) {
		this.bankPaymentMode = mode;
		return this;
	}

	@Override
	public void pay() {
		charge();

	}

}
