package com.demo.designpatterns.behavioral.state;

public abstract class State {

	Game game;

	public State(Game game) {
		super();
		this.game = game;
	}

	public abstract void onWelcomeScreen();

	public abstract void startGame();

	public abstract void playGame();

	public abstract void pauseGame();

	public abstract void endGame();

}
