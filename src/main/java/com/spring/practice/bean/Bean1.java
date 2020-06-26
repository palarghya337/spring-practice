package com.spring.practice.bean;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service(value = "bean1")
public class Bean1 {

	@Resource
	private Bean2 bean2;
	
	public Bean1() {
		System.out.println("Bean1 object created");
	}
}
