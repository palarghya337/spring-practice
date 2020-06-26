package com.spring.practice.beanfactory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

public class BeanFactoryAwareExample implements BeanFactoryAware{

	private BeanFactory beanFactory;
	public void setBeanFactory(BeanFactory beanFactory) {
		this.beanFactory = beanFactory;
	}
	public <T> T getBean(Class<T> classObj) {
		return beanFactory.getBean(classObj);
	}
}
