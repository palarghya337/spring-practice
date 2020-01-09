package com.spring.practice.utils;

import java.util.Objects;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.spring.practice.exception.InvalidDataException;

public final class SpringUtilities {

	private SpringUtilities() {
		/* Do not want to create object for this class
		 * as this is an Util class which will contain
		 * only static methods.*/
	}
	
	public static <T> T getDesiredObjectApplicationContext(String beanXmlFile, String beanID) {
		
		if (Objects.isNull(beanXmlFile)) {
			throw new InvalidDataException("beanXmlFile can not be blank");
		}
		ApplicationContext context = new ClassPathXmlApplicationContext(beanXmlFile);
		return getBean(context, beanID);
	}
	@SuppressWarnings("unchecked")
	@Deprecated
	public static <T> T getDesiredObjectXMLBeanFactory(String beanXMLFile, String objectID) {
		if (Objects.isNull(beanXMLFile)) {
			throw new InvalidDataException("beanXmlFile can not be blank");
		}
		XmlBeanFactory factory = new XmlBeanFactory (new ClassPathResource(beanXMLFile)); 
		return (T) factory.getBean(objectID); 
	}
	public static <T> T getDesiredObjectFileSystemXmlApplicationContext(String beanXMLFilePath, String beanID) {
		if (Objects.isNull(beanXMLFilePath)) {
			throw new InvalidDataException("beanXMLFilePath is mandatory field.");
		}
		ApplicationContext context = new FileSystemXmlApplicationContext(beanXMLFilePath);
		return getBean(context, beanID);
	}
	@SuppressWarnings("unchecked")
	public static <T> T getBean(ApplicationContext context, String beanID) {
		if (Objects.isNull(context)) {
			throw new NullPointerException("ApplicationContext can not be null");
		}
		return (T) context.getBean(beanID);
	}
}
