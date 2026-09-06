package com.demo.designpatterns.behavioral.state;

public class WelcomeScreen extends State {

	public WelcomeScreen(Game game) {
		super(game);
		System.out.println("-- Game in welcome screen state --");
	}

	@Override
	public void onWelcomeScreen() {
		System.err.println("on Welcome screen");
	}

	@Override
	public void startGame() {
		this.game.changeState(new StartGame());
	}

	@Override
	public void pauseGame() {
		// TODO Auto-generated method stub

	}

	@Override
	public void endGame() {
		// TODO Auto-generated method stub

	}

	@Override
	public void playGame() {
		// TODO Auto-generated method stub

	}

}
