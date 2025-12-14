package com.demo.devoxx.client;

import java.math.BigDecimal;

public class SampleTrade {

	public static void main(String[] args) {

		processTrade(new Buy("GOOG", BigDecimal.valueOf(200)));
		processTrade(new Buy("AMZN", BigDecimal.valueOf(60000)));

		processTrade(new Sell("MSFT", BigDecimal.valueOf(300)));
		processTrade(new Sell("INTL", BigDecimal.valueOf(40000)));
	}

	private static void processTrade(Trade trade) {

		AuditRules.audit(trade);
		trade.perform();
	}

}
