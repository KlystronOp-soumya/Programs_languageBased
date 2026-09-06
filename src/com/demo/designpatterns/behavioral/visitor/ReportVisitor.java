package com.demo.designpatterns.behavioral.visitor;

public interface ReportVisitor<R> {

	public R visit(FixedPriceContract fixedPriceContract);

	public R visit(TimeAndMaterialContract timeAndMaterialContract);

	public R visit(SupportContract supportContract);
}
