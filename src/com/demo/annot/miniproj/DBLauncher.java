package com.demo.annot.miniproj;

import org.h2.tools.Server;

//jdbc:h2:file:/E:/Program Files/Java Programs/JavaDemos/H2DB/sample
public class DBLauncher {

	public static void main(String[] args) {
		try {
			Server.main(args);
		} catch (Exception e) {
			System.exit(1);
		}

	}

}
