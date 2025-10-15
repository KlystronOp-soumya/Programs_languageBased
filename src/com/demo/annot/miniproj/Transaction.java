package com.demo.annot.miniproj;

import java.io.Serializable;
import java.util.Random;

import lombok.Data;

@Data
@ToTable(name = "TRANSACTIONS")
public class Transaction implements Serializable {

	private static final long serialVersionUID = 3314139730242352154L;

	@PrimaryKey(autoIncrement = true, name = "TXN_ID")
	private long transactionId;

	@Column(name = "NAME")
	private String name;

	@Column
	private String transactionType;

	@Column(name = "AMOUNT")
	private double amount;

	public Transaction(String name, String transactionType, double amount) {
		super();
		this.name = name;
		this.transactionType = transactionType;
		this.amount = amount;
	}

	public static class TransactionNameGenerator {

		private static final String[] VERBS = { "Create", "Update", "Delete", "Transfer", "Authorize", "Validate",
				"Process", "Sync" };

		private static final String[] OBJECTS = { "Invoice", "Payment", "Order", "Refund", "Subscription", "Account",
				"Token", "Session" };

		private static final String[] SUFFIXES = { "Request", "Event", "Command", "Action", "Job", "Task" };

		private static final Random RANDOM = new Random();

		public static String generateTransactionName() {
			String verb = VERBS[RANDOM.nextInt(VERBS.length)];
			String object = OBJECTS[RANDOM.nextInt(OBJECTS.length)];
			String suffix = SUFFIXES[RANDOM.nextInt(SUFFIXES.length)];
			int id = 1000 + RANDOM.nextInt(9000); // Optional numeric suffix

			return verb + object + suffix + "_" + id;
		}
	}
}
