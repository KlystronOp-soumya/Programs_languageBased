package com.demo.genericsenum;

import java.time.LocalDateTime;
import java.util.function.Predicate;

public enum Status {

	CREATED(

			(LocalDateTime t) -> t.isBefore(t.minusMonths(LocalDateTime.now().getYear())), "C"),
	PROCESSING,

	PROCESSED((LocalDateTime t) -> t.isAfter(t.minusMonths(LocalDateTime.now().getYear())), "PD")

	, RECEIVED, DISPATCHED, CANCELED, ABORTED(null, null);

	private Predicate<LocalDateTime> checkCreationTime;
	private String statusVal;

	private Status(Predicate<LocalDateTime> checkCreationTime, String value) {
		this.checkCreationTime = checkCreationTime;
		this.statusVal = value;
	}

	Status() {

	}

	public boolean getCheckCreationTime() {
		LocalDateTime dt = LocalDateTime.of(2025, 8, 3, 19, 32);
		return checkCreationTime.test(dt);
	}

	public String getStatusVal() {
		return statusVal;
	}

	public void setStatus() {
		if (this.getCheckCreationTime()) {
			if (this.equals(CREATED)) { //
				this.statusVal = "ORDER_CREATED";
			} else if (this.name().equals(RECEIVED)) {
				this.statusVal = "ORDER_RECEIVED";
			} else if (this.name().equals(PROCESSING)) {
				this.statusVal = "ORDER_PROCESSING";
			} else if (this.name().equals("PROCESSED")) {
				this.statusVal = "ORDER_PROCESSED";
			} else if (this.name().equals(DISPATCHED)) {
				this.statusVal = "ORDER_DISPATCHED";
			} else {
				this.statusVal = "";
			}
		} else {
			this.statusVal = "CANCELLED";
		}
	}

}
