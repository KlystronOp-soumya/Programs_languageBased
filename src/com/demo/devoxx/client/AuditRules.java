package com.demo.devoxx.client;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import com.demo.LogUtil;

public class AuditRules {

	public static void audit(Trade trade) {
		/*
		 * if (trade instanceof Buy) { auditBuy(trade); } if (trade instanceof Sell) {
		 * auditSell(trade); }
		 */

		/*
		 * TradeAuditor auditor = new BuyAuditor(); auditor.audit(trade);
		 */

		// The below is an example of pure OOP approach

		/*
		 * Optional<TradeAuditor> tradeAuditorOptional =
		 * Optional.ofNullable(createAuditor(trade));
		 * 
		 * tradeAuditorOptional.ifPresent(tradeAuditor -> tradeAuditor.audit(trade));
		 */

		var auditInfo = switch (trade) {

		// here by making the buy and sell record we can use destructuring
		case Buy buy when (buy.getAmount().compareTo(BigDecimal.valueOf(5000))) > 0 -> "auditing large buy";

		case Buy buy -> "...";

		case Sell sell when (sell.getAmount().compareTo(BigDecimal.valueOf(10000))) > 0 -> "auditing large sell";

		case Sell sell -> "...";

		// the below default is not required in case of sealed classes
		default -> throw new IllegalArgumentException("Unexpected value: " + trade);
		};

		LogUtil.info(AuditRules.class, auditInfo);
	}

	private static TradeAuditor createAuditor(Trade trade) {
		TradeAuditor tradeAuditor = null;
		var clazzName = "com.demo.devoxx.client." + trade.getClass().getSimpleName() + "Auditor";
		try {
			tradeAuditor = (TradeAuditor) Class.forName(clazzName).getDeclaredConstructor(null).newInstance(null);

		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | ClassNotFoundException ex) {

			ex.printStackTrace();
		}

		return tradeAuditor;
	}

	private static void auditBuy(Trade trade) {

	}

	private static void auditSell(Trade trade) {

	}

}
