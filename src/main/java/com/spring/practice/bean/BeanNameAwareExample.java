package com.spring.practice.bean;

import org.springframework.beans.factory.BeanNameAware;

import com.spring.practice.utils.Log;

public class BeanNameAwareExample implements BeanNameAware {

	public void setBeanName(String name) {
		Log.logInfo("Bean name is {0}", name);
	}
}
