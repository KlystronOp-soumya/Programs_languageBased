package com.demo.designpatterns.behavioral.memento;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Originator {

	private String state;

	public Memento createMemento() {

		return new Memento(state);
	}

	public void restoreMemento(Memento memento) {
		this.state = memento.getState();
	}
}
