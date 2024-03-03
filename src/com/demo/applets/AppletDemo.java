package com.demo.applets;

//A Hello World Applet

import java.applet.Applet;
import java.awt.Graphics;

public class AppletDemo extends Applet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Overriding paint() method
	@Override
	public void paint(Graphics g) {
		g.drawString("Hello World", 20, 20);

	}

	@Override
	public void destroy() {
		System.out.println("Destroyed");
	}
}
