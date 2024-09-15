/**
 * 
 */
package com.demo.designpatterns.startegy;

/**
 * @author Soumyadeep Paul
 * 
 *         The strategy pattern is all about separating out the varying
 *         attributes from a class
 */
public class StartegyPattern {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		Duck model = new ModelDuck();

		// duck is created
		model.performFly();
		model.performQuack();

		// now set the behavior dynamically
		model.setFlyBehavior(new FlyWithWings());
		model.setQuackBehavior(new Quack());

		model.performFly();
		model.performQuack();

		// now add the behavior for the Decoy duck using Lambda

		FlyBehavior flyBehavior = () -> {
			System.out.println("Can not fly");
		};

		QuackBehavior quackBehavior = () -> System.out.println("making sounds digitally");

		model.setFlyBehavior(flyBehavior);
		model.setQuackBehavior(quackBehavior);

		model.performFly();
		model.performQuack();
	}

}
