/**
 * 
 */
package com.demo.javaapis;

/**
 * @author USER Static interface methods were introduced in Java 9 removed code
 *         duplication better encapsulates code and hides implementations
 */

interface TennisStrokes {

	static void smash() {
		System.out.println("Get the ball");
		System.out.println("hit a smash");
	}

	static void backhand() {
		System.out.println("Get the ball");
		System.out.println("hit a backhand");
	}

}

interface TennisStrokesConcise { // this interface removes code duplication

	private static void hit(final String type) {
		System.out.println("Get the ball");
		System.out.println("hit a " + type);
	}

	static void smashThat() { // static can only call static , non static can not call the static hit method
		hit("smash");
	}

	default void backhandThat() {
		hit("backhand");
	}
}

class PlayTennis implements TennisStrokesConcise {

	@Override
	public void backhandThat() {
		System.out.println("Calls the super");
		TennisStrokesConcise.super.backhandThat(); // calls the super one
		System.out.println("My override");
	}
}

public class StaticInterfaceDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		TennisStrokesConcise tennisStrokes = new PlayTennis();
		tennisStrokes.backhandThat(); // this appeared as this is public
		TennisStrokesConcise.smashThat(); // this is a static method hence it can be called

	}

}
