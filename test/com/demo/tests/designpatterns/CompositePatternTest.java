package com.demo.tests.designpatterns;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import com.demo.designpatterns.composite.Composite;
import com.demo.designpatterns.composite.Equipment;
import com.demo.designpatterns.composite.HddMemory;

public class CompositePatternTest {

	@Test
	void testCompositePatternForEquipment() {

		Equipment hdd = new HddMemory("HDD", 5000.00, 1);
		Equipment ram = new HddMemory("RAM", 12000, 4);

		Composite equipmentComposite = new Composite();
		equipmentComposite.addEquipment(hdd).addEquipment(ram);

		assertEquals(5000.00, hdd.getCost(), 100);
		assertEquals(48000, ram.getCost(), 100);
		assertEquals(53000.0, equipmentComposite.getTotalCostOfEquipments(), 0.5);

	}
}
