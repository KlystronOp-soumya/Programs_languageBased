package com.demo.tests.designpatterns;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.demo.designpatterns.SingletonEager;
import com.demo.designpatterns.SingletonStaticBlock;

class SingletonPatternTest {

	@Test
	@DisplayName("singletonEagerSameInstanceTest")
	void testSingletonEagerInstance() {

		SingletonEager eagerInstance1 = SingletonEager.getEagerInstance();
		SingletonEager eagerInstance2 = SingletonEager.getEagerInstance();

		assertEquals(eagerInstance1, eagerInstance2, "the instances are not same");

	}

	@Test
	@DisplayName("singletonStaticBlockSameInstanceTest")
	void testSingletonStaticBlockInstance() {

		SingletonStaticBlock staticInstance1 = SingletonStaticBlock.getInstance();
		SingletonStaticBlock staticInstance2 = SingletonStaticBlock.getInstance();

		assertEquals(staticInstance1, staticInstance2);

	}

}
