package com.demo.designpatterns.structural.flyweight;

import java.util.Random;

public class GenerateArmy {

	public static void main(String[] args) {

		int toDraw = 1000;
		Army army = new Army();
		FighterRank currentFighterRank;
		Random random = new Random();

		for (int i = 0; i <= toDraw; i++) {

			switch (random.nextInt(3)) {

			case 0 -> currentFighterRank = FighterRank.PRIVATE;
			case 1 -> currentFighterRank = FighterRank.SERGEANT;
			case 2 -> currentFighterRank = FighterRank.MAJOR;
			default -> throw new IllegalArgumentException("No Role Found");

			}

			// when a rank is encountered first time it will create an object
			// when 3 ranks are present in the Map, it will refer to that and will not
			// create another object
			// 1000 instances are not required as 1000 objects will have any of the 3 ranks
			// so memory is not wasted
			army.spawnFighter(currentFighterRank);
		}

		army.drawArmy();
	}

}
