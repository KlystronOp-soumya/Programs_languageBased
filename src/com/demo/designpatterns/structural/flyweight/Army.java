package com.demo.designpatterns.structural.flyweight;

import java.util.ArrayList;
import java.util.List;

public class Army {

	private final List<Fighter> army = new ArrayList<>();

	public void spawnFighter(FighterRank rank) {

		army.add(FighterFactory.getFighterByRank(rank));
	}

	public void drawArmy() {

		for (Fighter fighter : army) {

			String symbol = switch (fighter.getFighterRank()) {
			case PRIVATE -> "P ";
			case SERGEANT -> "S ";
			case MAJOR -> "M ";
			};

			System.out.print(symbol);
		}

		System.out.println();

	}
}
