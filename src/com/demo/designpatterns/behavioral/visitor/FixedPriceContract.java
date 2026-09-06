package com.demo.designpatterns.behavioral.visitor;

public class FixedPriceContract implements ReportElement {

	long costPerYear;

	public FixedPriceContract(long costPerYear) {
		super();
		this.costPerYear = costPerYear;
	}

	@Override
	public <R> R accept(ReportVisitor<R> reportVisitor) {

		return reportVisitor.visit(this);
	}

}
