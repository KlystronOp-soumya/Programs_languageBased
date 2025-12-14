package com.demo.devoxx.client;

public sealed interface Trade permits Buy, Sell {

	void perform();
}
