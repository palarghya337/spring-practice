package com.spring.practice.bean;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component
public class Bean2 {

	@Resource(name = "bean3")
	private Bean3 bean3;
	
	public Bean2() {
		System.out.println("Bean2 object created.");
	}
}
