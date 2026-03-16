package com.demo.designpatterns.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

public class FighterFactory {

	static Map<FighterRank, Fighter> fighters = new HashMap<>();

	public static Fighter getFighterByRank(FighterRank rank) {

		return fighters.computeIfAbsent(rank, (r) -> new Fighter(r));
	}
}
