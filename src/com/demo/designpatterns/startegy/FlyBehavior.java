package com.demo.designpatterns.startegy;

/*
 * 
 * This is a behavior class which is a varying attribute
 * Hence it is created as an interface
 * 
 * The question is which is better to add as an abstract class or interface
 * It should be interface as it is always best to implement to interface not to any concrete class
 * 
 * */
@FunctionalInterface
public interface FlyBehavior {

	void fly();

}
