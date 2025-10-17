package com.demo.genericsenum;

import java.util.function.Function;

public record EnumMatcher<T>(Enum<?> enumConstant, Function<T, String> getter) {

	static <T> EnumMatcher<T> forEnum(Enum<?> enumCons, Function<T, ? extends Enum<?>> getter) {

		return new EnumMatcher<>(enumCons, getter.andThen(EnumMatcher::checkNullSafe));

	}

	static String checkNullSafe(Enum<?> enumCons) {
		return enumCons == null ? null : enumCons.name();
	}

	static String checkEnumVal(Enum<?> enumCons) {

		return enumCons.name().isBlank() ? "NO_STATUS" : enumCons.name();
	}
}
