package com.demo.designpatterns.singleton;

public class SingletonBillPugh {

	private SingletonBillPugh() {
	}

	// Lazy initialized because of the inner class as it is not initialized with the
	// outer class.
	private static class InnerStaticClass {
		private static final SingletonBillPugh BILL_PUGH = new SingletonBillPugh();
	}

	public SingletonBillPugh getInstance() {
		return InnerStaticClass.BILL_PUGH;
	}
}
