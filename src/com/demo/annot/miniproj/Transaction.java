package com.demo.annot.miniproj;

import java.io.Serializable;

import lombok.Data;

@Data
@ToTable(name = "TRANSACTIONS")
public class Transaction implements Serializable {

	private static final long serialVersionUID = 3314139730242352154L;

	@PrimaryKey(autoIncrement = true, name = "TXN_ID")
	private long transactionId;

	@Column
	private String name;

	@Column
	private String transactionType;

	@Column
	private double amount;

	public Transaction(String name, String transactionType, double amount) {
		super();
		this.name = name;
		this.transactionType = transactionType;
		this.amount = amount;
	}

}
