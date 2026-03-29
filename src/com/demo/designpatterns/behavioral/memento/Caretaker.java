package com.demo.designpatterns.behavioral.memento;

import java.util.ArrayList;
import java.util.List;

public class Caretaker {

	private List<Memento> mementoes;

	public Caretaker() {
		super();
		this.mementoes = new ArrayList<Memento>();
	}

	public void saveState(Memento mem) {

		this.mementoes.add(mem);

	}

	public Memento restoreState(int index) {

		return this.mementoes.get(index);
	}
}
