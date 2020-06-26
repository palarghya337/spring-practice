package com.spring.practice.utils;

import java.text.MessageFormat;
import java.util.logging.Logger;

import com.spring.practice.exception.InvalidOperationException;

public final class Log {

	private static final Logger logger = Logger.getLogger(Log.class.getSimpleName());
	static {
		System.setProperty("java.util.logging.SimpleFormatter.format", "%4$s: %5$s %n");
	}
	private Log() {
		throw new InvalidOperationException("Object creation is not allowed.");
	}
	public static void logInfo(String pattern, Object...arguments) {

		StackTraceElement element = Thread.currentThread().getStackTrace()[2];
		String methodName = element.getMethodName();
		try {
			Class<?> c = Class.forName(element.getClassName());
			String className = c.getSimpleName();
			String finalMessage = formatMessage("<{0}><{1}>: {2}", className,
					methodName, formatMessage(pattern, arguments));
			logger.info(finalMessage);
		} catch (ClassNotFoundException e) {
			logger.info(e.getMessage());
		}
	}
	public static void logMessage(String message) {
		logger.info(message);
	}
	private static String formatMessage(String pattern, Object...arguments) {
		MessageFormat format = new MessageFormat(pattern);
		return format.format(arguments);
	}
}