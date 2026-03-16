package com.demo.designpatterns.structural.flyweight;

import lombok.Getter;

@Getter
public class Fighter implements Sprite {

	private FighterRank fighterRank;

	public Fighter(FighterRank fighterRank) {
		super();
		this.fighterRank = fighterRank;
	}

	@Override
	public void draw() {

		System.out.println("Drawing fighter");
	}

	@Override
	public void move(int x, int y) {

		System.out.println("Moving fighter to position " + x + ", " + y);
	}

}
