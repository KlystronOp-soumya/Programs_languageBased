package com.demo.designpatterns.behavioral.startegy;

public class StrategyExecutor {

	public PrintStartegy printStartegy;

	public StrategyExecutor(PrintStartegy printStartegy) {
		super();
		this.printStartegy = printStartegy;
	}

	public void printString(final String input) {
		System.out.println(this.printStartegy.formatString(input));
	}
}
