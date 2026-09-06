package com.demo.designpatterns.behavioral.visitor;

public interface ReportElement {

	public <R> R accept(ReportVisitor<R> reportVisitor);
}
