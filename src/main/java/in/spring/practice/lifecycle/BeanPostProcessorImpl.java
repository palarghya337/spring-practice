package com.spring.practice.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class BeanPostProcessorImpl implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(
			Object bean, String beanName) throws BeansException {
		
		System.out.println(getMethodName() + ": " + beanName);
		return BeanPostProcessor.super
				.postProcessBeforeInitialization(bean, beanName);
	}
	@Override
	public Object postProcessAfterInitialization(
			Object bean, String beanName) throws BeansException {
		
		System.out.println(getMethodName() + ": " + beanName);
		return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
	}
	
	public String getMethodName() {
		return Thread.currentThread().getStackTrace()[2].getMethodName();
	}
}
