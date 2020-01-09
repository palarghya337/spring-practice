package com.spring.practice.bean;

import org.springframework.stereotype.Component;

import com.spring.practice.utils.Log;

@Component
public class ServiceBean {

	public ServiceBean() {
		Log.logInfo("Inside constructor of {0} class",
				ServiceBean.class.getSimpleName());
	}
	public String getSomeService() {
		return "Providing some service.";
	}
}
