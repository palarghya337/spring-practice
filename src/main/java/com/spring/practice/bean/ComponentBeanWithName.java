package com.spring.practice.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.spring.practice.utils.Log;

@Component("anyNameIsFine")
public class ComponentBeanWithName {

	@Value("${beanIDOfComponentBeanWithName}")
	private String beanID;
	
	private static final String CLASS_NAME = ComponentBeanWithName
			.class.getSimpleName();
	public ComponentBeanWithName() {
		Log.logInfo("Inside constructor of {0}", CLASS_NAME);
	}
	public void someMethod() {
		Log.logInfo("Hay you are here..");
	}
	public String getBeanID() {
		return beanID;
	}
}
