package com.spring.practice.bean;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;

@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class SingletonBean {

	public SingletonBean() {
		// As this is singleton so private method
	}
	public String method() {
		return "method of SingletonBean class";
	}
}
