package com.demo.devoxx.client;

import java.math.BigDecimal;

import com.demo.LogUtil;

public class BuyAuditor implements TradeAuditor {

	@Override
	public void audit(Trade trade) {
		if (trade instanceof Buy buy) {
			if (buy.getAmount().compareTo(BigDecimal.valueOf(100000)) > 0) {
				LogUtil.info(getClass(), "Auditing for large amount");
			} else {
				LogUtil.debug(getClass(), "...");
			}
		} else {
			throw new RuntimeException("Invalid trade ..expecting a Buy");
		}

	}

}
