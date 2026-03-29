package com.demo.designpatterns.behavioral.memento;

public class Client {

	public static void main(String[] args) {
		Originator originator = new Originator("Initila state");

		Caretaker caretaker = new Caretaker();
		caretaker.saveState(originator.createMemento());
		System.out.println("Current state is: " + originator.getState());

		originator.setState("State 1");
		caretaker.saveState(originator.createMemento());
		System.out.println("Current state is: " + originator.getState());

		originator.setState("State 2");
		caretaker.saveState(originator.createMemento());
		System.out.println("Current state is: " + originator.getState());

		System.out.println("--------------------------");
		originator.restoreMemento(caretaker.restoreState(1));
		System.out.println("Current state is: " + originator.getState());

		originator.restoreMemento(caretaker.restoreState(0));
		System.out.println("Current state is: " + originator.getState());

		originator.restoreMemento(caretaker.restoreState(2));
		System.out.println("Current state is: " + originator.getState());

	}
}