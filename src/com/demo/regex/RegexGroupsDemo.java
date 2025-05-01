package com.demo.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexGroupsDemo {
	public static void main(String[] args) {
		String text = "Agent 007, Agent 008, Agent 009";
		String regex = "Agent (\\d{3})"; // Capturing the agent numbers

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(text);

		while (matcher.find()) {
			System.out.println("Full Match: " + matcher.group(0)); // Entire match
			System.out.println("Captured Group: " + matcher.group(1)); // First group (agent number)
		}
	}
}