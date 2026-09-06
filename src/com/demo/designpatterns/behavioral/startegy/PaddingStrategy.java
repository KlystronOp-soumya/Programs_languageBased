package com.demo.designpatterns.behavioral.startegy;

import org.apache.commons.lang3.StringUtils;

public class PaddingStrategy implements PrintStartegy {

	@Override
	public String formatString(String input) {

		return StringUtils.leftPad(input, input.length() + 5);
	}

}
