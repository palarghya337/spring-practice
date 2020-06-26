package com.spring.practice.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class UserBean implements InitializingBean, DisposableBean {

	private static final String CLASS_NAME = UserBean.class.getSimpleName();
	public UserBean() {
		System.out.println("Constructor: " + CLASS_NAME);
	}
	@PostConstruct
	public void postConstructMethod() {
		System.out.println(getMethodName() + ": " + CLASS_NAME);
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println(getMethodName() + ": " + CLASS_NAME);
	}
	
	public void init() {
		System.out.println(getMethodName() + ": " + CLASS_NAME);
	}
	@PreDestroy
	public void preDestroyMethod() {
		System.out.println(getMethodName() + ": " + CLASS_NAME);
	}
	@Override
	public void destroy() throws Exception {
		System.out.println(getMethodName() + ": " + CLASS_NAME);
	}
	public void customDestroy() {
		System.out.println(getMethodName() + ": " + CLASS_NAME);
	}
	public String getMethodName() {
		return Thread.currentThread().getStackTrace()[2].getMethodName();
	}
}
