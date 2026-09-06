package com.demo.designpatterns.behavioral.state;

public class Game {

	private State state = new WelcomeScreen(this);

	public void changeState(State state) {
		this.state = state;
	}
}
