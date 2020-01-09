package com.spring.practice.bean;

import org.springframework.stereotype.Component;

import com.spring.practice.utils.Log;

@Component
public class ComponentBeanWithoutName {

	private static final String CLASS_NAME = ComponentBeanWithoutName
			.class.getSimpleName();
	public ComponentBeanWithoutName() {
		Log.logInfo("Inside constructor of {0}", CLASS_NAME);
	}
	public void someMethod() {
		Log.logInfo("Hay you are here..");
	}
}
