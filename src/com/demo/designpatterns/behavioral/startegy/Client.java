package com.demo.designpatterns.behavioral.startegy;

public class Client {

	public static void main(String[] args) {

		PrintStartegy lowerCasePrintStartegy = new LowerCaseStrategy();
		PrintStartegy randomCasePrintStartegy = new RandomCaseStrategy();

		StrategyExecutor executor = new StrategyExecutor(randomCasePrintStartegy);
		executor.printString("HelloWorld");
	}
}
