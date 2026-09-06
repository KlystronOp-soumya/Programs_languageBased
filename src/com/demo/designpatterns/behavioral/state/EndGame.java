package com.demo.designpatterns.behavioral.state;

public class EndGame extends State {

	public EndGame(Game game) {
		super(game);
		System.out.println("-- Ending Game --");
	}

	@Override
	public void onWelcomeScreen() {
		System.out.println(" -- Back to Welcome screen --");
		this.game.changeState(new WelcomeScreen(this.game));
	}

	@Override
	public void startGame() {
		System.out.println("-- Can not Start --");
	}

	@Override
	public void playGame() {
		System.out.println(" -- Can not resume --");

	}

	@Override
	public void pauseGame() {
		System.out.println(" -- Can not pause --");

	}

	@Override
	public void endGame() {
		System.out.println(" -- Game Ended already --");

	}

}
