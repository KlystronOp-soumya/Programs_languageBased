package com.demo;

import java.util.Arrays;
import java.util.Optional;

enum Source {

	ACTIVE, INACTIVE, FAILED, PENDING;
}

enum Target {

	ACTIVE, INACTIVE, FAILED, PENDING;
}

class EnumMapper {

	// this throws IllegalState if an enum is not present
	public static <S extends Enum<S>, T extends Enum<T>> T mapToEnum(S sourceEnumValue, Class<T> targetEnumClass) {

		return Optional.ofNullable(sourceEnumValue).map(Enum::name)
				.map(sourceEnumName -> Enum.valueOf(targetEnumClass, sourceEnumName)).orElse(null);
	}

	public static <T extends Enum<T>> T mapToEnumItr(String name, Class<T> targetEnumClass) {

		return Optional.ofNullable(name).flatMap(n -> Arrays.stream(targetEnumClass.getEnumConstants())
				.filter(enumCons -> enumCons.name().equals(n)).findFirst()).get();
	}
}

public class EnumMapperDemo {

	public static void main(String[] args) {

		System.out.println(EnumMapper.mapToEnum(Source.ACTIVE, Target.class).getClass().getName());
		System.out.println(EnumMapper.mapToEnumItr(Source.ACTIVE.name(), Target.class));
	}
}
