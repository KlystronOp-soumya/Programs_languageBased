package com.demo.devoxx.client;

import java.math.BigDecimal;

import com.demo.LogUtil;

public class SellAuditor implements TradeAuditor {

	@Override
	public void audit(Trade trade) {
		if (trade instanceof Sell sell) {
			if (sell.getAmount().compareTo(BigDecimal.valueOf(20000)) > 0) {
				LogUtil.info(getClass(), "Auditing for large amount");
			} else {
				LogUtil.debug(getClass(), "...");
			}
		} else {
			throw new RuntimeException("Invalid trade ..expecting a Sell");
		}

	}

}
