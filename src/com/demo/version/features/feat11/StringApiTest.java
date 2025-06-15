package com.demo.version.features.feat11;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringApiTest {

	@Test
	void test() {
		fail("Not yet implemented");
	}

	@Test
	@DisplayName(".repeat() test")
	public void stringRepeatTest() {
		String test = "Hi";
		String expected = "HiHiHi ";
		String actual = test.repeat(3);
		assertThat(actual).isEqualTo(expected.stripTrailing());

	}

	@Test
	@DisplayName("Collection.toArray() test")
	public void collectionToArrayTest() {

		List<String> testList = Arrays.asList("Foo", "Bar");
		String[] expectedArr = { "Foo", "Bar" };
		String[] actualArr = testList.toArray(String[]::new);

		assertThat(actualArr).containsExactly("Foo", "Bar");
	}

	@Test
	@DisplayName("Predicate.Not() test")
	public void predicatNotTest() {
		// write a Stream to change the case
		List<String> langs = List.of("java", "python", "kotlin", "cpp", " ", " ");
		List<String> actual = langs.stream().filter(Predicate.not(String::isBlank)).map(String::toUpperCase)
				.collect(Collectors.toList());
		List<String> expectedList = List.of("JAVA", "PYTHON", "KOTLIN", "CPP");

		assertThat(actual).isNotEmpty();
		assertThat(actual).containsAll(expectedList);
	}

	@Test
	@DisplayName("local var in stream test")
	public void localVarInStreamTest() {
		List<String> sampleList = Arrays.asList("Java", "Kotlin");
		String resultString = sampleList.stream().map((var x) -> x.toUpperCase()).collect(Collectors.joining(", "));
		assertThat(resultString).isEqualTo("JAVA, KOTLIN");
	}

}
