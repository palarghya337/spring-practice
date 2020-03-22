package com.spring.practice.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service(value = "bean1")
public class Bean1 {

	@Autowired
	@Qualifier(value = "bean2")
	private Bean2 bean2;
	
	public Bean1() {
		System.out.println("Bean1 object created");
	}
}
