package com.demo.designpatterns.behavioral.visitor;

public class MonthlyCostReportVisitor implements ReportVisitor<Long> {

	@Override
	public Long visit(FixedPriceContract fixedPriceContract) {
		return fixedPriceContract.costPerYear / 12;
	}

	@Override
	public Long visit(TimeAndMaterialContract timeAndMaterialContract) {
		return timeAndMaterialContract.costPerHour * timeAndMaterialContract.hours;
	}

	@Override
	public Long visit(SupportContract supportContract) {
		return supportContract.costPerContract;
	}

}
