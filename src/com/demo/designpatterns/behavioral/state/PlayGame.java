package com.demo.designpatterns.behavioral.state;

public class PlayGame extends State {

	public PlayGame(Game game) {
		super(game);
		System.out.println("-- Game in playing state --");
	}

	@Override
	public void onWelcomeScreen() {
		// TODO Auto-generated method stub

	}

	@Override
	public void startGame() {
		// TODO Auto-generated method stub

	}

	@Override
	public void playGame() {
		System.out.println(" -- Playing Game --");

	}

	@Override
	public void pauseGame() {
		System.out.println(" -- Pausing Game --");

	}

	@Override
	public void endGame() {
		System.out.print("-- Ending Game --");

	}

}
