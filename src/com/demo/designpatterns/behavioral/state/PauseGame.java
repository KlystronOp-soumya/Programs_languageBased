package com.demo.designpatterns.behavioral.state;

public class PauseGame extends State {

	public PauseGame(Game game) {
		super(game);
		System.out.println("-- Game paused --");
	}

	@Override
	public void onWelcomeScreen() {
		System.out.println(" -- Hard Reset! Progress Lost --");
		this.game.changeState(new WelcomeScreen(game));
	}

	@Override
	public void startGame() {
		System.out.println(" -- Game Restarted --");
		this.game.changeState(new StartGame());
	}

	@Override
	public void playGame() {
		System.out.println(" -- Game Resumed --");
		this.game.changeState(new PlayGame(game));
	}

	@Override
	public void pauseGame() {
		System.out.println(" -- Already Paused --");
		this.game.changeState(new PauseGame(game));
	}

	@Override
	public void endGame() {
		this.game.changeState(new EndGame(this.game));

	}

}
