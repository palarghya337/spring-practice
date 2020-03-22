package com.spring.practice.bean;

import org.springframework.stereotype.Service;

@Service(value = "bean3")
public class Bean3 {

	public Bean3() {
		System.out.println("Bean3 object created.");
	}
}
