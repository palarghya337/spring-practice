package com.spring.practice.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component(value = "bean2")
public class Bean2 {

	@Autowired
	@Qualifier(value = "bean3")
	private Bean3 bean3;
	
	public Bean2() {
		System.out.println("Bean2 object created.");
	}
}
