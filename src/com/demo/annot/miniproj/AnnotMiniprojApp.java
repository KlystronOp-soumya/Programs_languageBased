package com.demo.annot.miniproj;

public class AnnotMiniprojApp {

	public static void main(String[] args) {

		Transaction tx1 = new Transaction(Transaction.TransactionNameGenerator.generateTransactionName(), "CR", -100);
		Hibernate<Transaction> emHibernate = new Hibernate<>();
		try {
			emHibernate.save(tx1);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
