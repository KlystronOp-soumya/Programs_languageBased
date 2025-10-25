package com.problems;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import lombok.AllArgsConstructor;
import lombok.Data;

enum OrderStatus {

	PLACED, PAYMENT_RECEIVED, DISPATCHED, DELIVERED;

	private Predicate<Order> checkDispatch;
	private boolean dispatchable;

	public boolean shouldDispatch(final Order order) {
		checkDispatch = (Order o) -> o.getOrderStatus() == PAYMENT_RECEIVED;
		dispatchable = checkDispatch.test(order);
		return dispatchable;
	}

}

@Data
@AllArgsConstructor
class Order {
	private int orderId;
	private LocalDate orderDate;
	private LocalTime orderTime;
	private OrderStatus orderStatus;

	public static OrderStatus orderStatus(Order o) {
		return o.getOrderStatus();
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderDate=" + orderDate + ", orderTime=" + orderTime + ", orderStatus="
				+ orderStatus + "]";
	}

}

class FindValidOrders<T extends Enum<T>, L extends Collection<V>, V> {

	public V findMatchedEntry(T enumConditionCheck, L sourceListWithEnums, Function<V, Enum<T>> keyExtractor) {

		return sourceListWithEnums.stream().filter(e -> keyExtractor.apply(e) == enumConditionCheck).findFirst()
				.orElse(null);

	}

}

class EnumValidationUitls<T extends Enum<?>, S extends Collection<E>, E> {

	private S listToValidate;
	private T enumValToCheck;

	public EnumValidationUitls(S listToValidate, T enumValToCheck) {
		this.listToValidate = listToValidate;
		this.enumValToCheck = enumValToCheck;
	}

	public record EnumMatcher<T extends Enum<?>>(T constant, Function<T, String> getter) {

	}

}

public class EnumValidatioMain {

	public static void main(String[] args) {
		Order order1 = new Order(0, LocalDate.now(), LocalTime.now(), OrderStatus.PAYMENT_RECEIVED);
		System.out.println("Order dispatchable:" + order1.getOrderStatus().shouldDispatch(order1));

		FindValidOrders<OrderStatus, List<Order>, Order> validOrders = new FindValidOrders();
		System.out.println(
				validOrders.findMatchedEntry(OrderStatus.PAYMENT_RECEIVED, List.of(order1), Order::orderStatus));

	}

}
