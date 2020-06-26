package com.spring.practice.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.spring.practice.bean.BeanNameAwareExample;
import com.spring.practice.bean.PostConstructAndPreDestroy;
import com.spring.practice.bean.SingletonBean;
import com.spring.practice.beanfactory.BeanFactoryAwareExample;

/**
 * @author Bittu
 *
 */
@Configuration
@ComponentScan("com.spring.practice.bean")
@PropertySource("com/spring/practice/properties/PropertyFile.properties")
public class ConfigurationClass {

	@Bean(name = "beanNameAwareExample")
	public BeanNameAwareExample getBeanNameAwareExample() {
		return new BeanNameAwareExample();
	}
	@Bean
	public BeanFactoryAwareExample getBeanFactoryAwareExample() {
		return new BeanFactoryAwareExample();
	}
	@Bean("singletonBean")
	public SingletonBean getSingletonBean() {
		return new SingletonBean();
	}
	/**
	 * In this method we are creating a new instance of
	 * {@linkplain PostConstructAndPreDestroy} class and we
	 * are initializing the init and destroy method.
	 * @return {@linkplain PostConstructAndPreDestroy}
	 */
	@Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
	public PostConstructAndPreDestroy getPostConstructAndPreDestroy() {
		return new PostConstructAndPreDestroy();
	}
}
