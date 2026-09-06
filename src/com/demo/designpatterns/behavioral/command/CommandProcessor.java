package com.demo.designpatterns.behavioral.command;

import java.util.LinkedList;
import java.util.List;

public class CommandProcessor {

	private List<Command> commands;

	public CommandProcessor() {
		super();
		this.commands = new LinkedList<>();
	}

	public CommandProcessor addCommand(Command command) {

		this.commands.add(command);
		return this;
	}

	public void processCommands() {

		this.commands.forEach(eachCommand -> eachCommand.execute());
	}

}
