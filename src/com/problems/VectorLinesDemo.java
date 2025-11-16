package com.problems;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

public class VectorLinesDemo {

	// Generic predicate factory using key extractor
	public static <T, K> Predicate<T> byKey(Function<T, K> keyExtractor, K value) {
		return t -> Objects.equals(keyExtractor.apply(t), value);
	}

	// Period class
	public static class Period {
		LocalDate startDate;
		LocalDate endDate;

		public Period(LocalDate startDate, LocalDate endDate) {
			this.startDate = startDate;
			this.endDate = endDate;
		}

		public LocalDate getStartDate() {
			return startDate;
		}

		public LocalDate getEndDate() {
			return endDate;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (!(o instanceof Period))
				return false;
			Period period = (Period) o;
			return Objects.equals(startDate, period.startDate) && Objects.equals(endDate, period.endDate);
		}

		@Override
		public int hashCode() {
			return Objects.hash(startDate, endDate);
		}

		@Override
		public String toString() {
			return startDate + " -> " + endDate;
		}
	}

	// CalculatedValue class
	public static class CalculatedValue {
		Period period;
		BigDecimal rate;
		BigDecimal amount;

		public CalculatedValue(Period period, BigDecimal rate, BigDecimal amount) {
			this.period = period;
			this.rate = rate;
			this.amount = amount;
		}

		public Period getPeriod() {
			return period;
		}

		public BigDecimal getRate() {
			return rate;
		}

		public BigDecimal getAmount() {
			return amount;
		}
	}

	// VectorLines wrapper
	public static class VectorLines {
		List<CalculatedValue> values = new ArrayList<>();

		public void add(CalculatedValue eachVline) {
			values.add(eachVline);
		}
	}

	// Core calculation using the byKey predicate and single stream pipeline
	public static BigDecimal calculateAmountRateSum(VectorLines noOfFreqs, VectorLines vlines) {
		return vlines.values.stream().map(eachVline -> eachVline.amount.multiply(noOfFreqs.values.stream()
				.filter(byKey(CalculatedValue::getPeriod, eachVline.period)).findFirst()
				.orElseThrow(() -> new IllegalArgumentException("No rate found for period: " + eachVline.period)).rate))
				.reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	// Example usage
	public static void main(String[] args) {
		VectorLines noOfFreqs = new VectorLines();
		VectorLines vlines = new VectorLines();

		Period p1 = new Period(LocalDate.of(2025, 1, 31), LocalDate.of(2026, 12, 31));
		Period p2 = new Period(LocalDate.of(2026, 1, 31), LocalDate.of(2027, 12, 31));

		noOfFreqs.add(new CalculatedValue(p1, new BigDecimal("5"), null));
		noOfFreqs.add(new CalculatedValue(p2, new BigDecimal("10"), null));

		vlines.add(new CalculatedValue(p1, null, new BigDecimal("100")));
		vlines.add(new CalculatedValue(p2, null, new BigDecimal("200")));

		BigDecimal result = calculateAmountRateSum(noOfFreqs, vlines);
		System.out.println("Total Amount * Rate = " + result);
	}
}
