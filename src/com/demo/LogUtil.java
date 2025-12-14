package com.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class LogUtil {

	private LogUtil() {
		// prevent instantiation
	}

	/**
	 * Get a logger for the given class.
	 */
	public static Logger getLogger(Class<?> clazz) {
		return LoggerFactory.getLogger(clazz);
	}

	/**
	 * Fast logging methods with varargs for message formatting.
	 */
	public static void info(Class<?> clazz, String message, Object... args) {
		LoggerFactory.getLogger(clazz).info(message, args);
	}

	public static void debug(Class<?> clazz, String message, Object... args) {
		LoggerFactory.getLogger(clazz).debug(message, args);
	}

	public static void warn(Class<?> clazz, String message, Object... args) {
		LoggerFactory.getLogger(clazz).warn(message, args);
	}

	public static void error(Class<?> clazz, String message, Object... args) {
		LoggerFactory.getLogger(clazz).error(message, args);
	}

	public static void trace(Class<?> clazz, String message, Object... args) {
		LoggerFactory.getLogger(clazz).trace(message, args);
	}
}
