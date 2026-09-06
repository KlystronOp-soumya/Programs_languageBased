package com.demo.designpatterns.behavioral.observer;

public class Editor {

	public EventManager events = new EventManager("open", "save");
	String file = "";

	void openFile(String fileName) {
		this.file = fileName;
		events.notify("open", file);
	}

	void saveFile() {
		if (file != "") {
			events.notify("save", file);
		}
	}
}
