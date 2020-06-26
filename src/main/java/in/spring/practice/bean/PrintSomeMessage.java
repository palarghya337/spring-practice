package com.spring.practice.bean;

import com.spring.practice.utils.Log;

public class PrintSomeMessage {

	private String someMessage;
	private static int instanceCount = 0;

	public PrintSomeMessage() {
		// Default Constructor.
		Log.logMessage("Inside PrintSomeMessage Constructor");
	}
	public PrintSomeMessage(String someMessage) {
		this.someMessage = someMessage;
	}

	public String getSomeMessage() {
		return someMessage;
	}

	public void setSomeMessage(String printSomeMessage) {
		this.someMessage = printSomeMessage;
	}
	public static void setUp() {
		Log.logMessage("Method initiated. Available instance: " + ++instanceCount);
	}
	public static void tearDown() {
		Log.logMessage("Method destroy. Available instance: " + --instanceCount);
	}
	@Override
	public String toString() {
		return "PrintSomeMessage [someMessage=" + someMessage + "]";
	}
}
