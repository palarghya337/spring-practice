package com.spring.practice.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.practice.bean.Bean1;

public class NestedBeanExample {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(Bean1.class);
		context.close();
	}

}
