package com.demo.regex;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexPatternDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pattern pattern = Pattern.compile("(\\d)\\,(\\d+)");
		Matcher matcher = pattern.matcher("1,546");
		String[] mStrings = pattern.split("1,546");
		System.out.println(mStrings.length);

		Arrays.asList(mStrings).stream().forEach((e) -> System.out.println(e));

	}

}
