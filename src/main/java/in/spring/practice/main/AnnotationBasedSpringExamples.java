package com.spring.practice.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.SpringVersion;

import com.spring.practice.bean.BeanNameAwareExample;
import com.spring.practice.bean.ComponentBeanWithName;
import com.spring.practice.bean.ComponentBeanWithoutName;
import com.spring.practice.bean.LiteModeBeanExample;
import com.spring.practice.bean.PracticeBean;
import com.spring.practice.bean.ServiceBean;
import com.spring.practice.bean.SingletonBean;
import com.spring.practice.beanfactory.BeanFactoryAwareExample;
import com.spring.practice.configuration.ConfigurationClass;
import com.spring.practice.utils.Log;

public class AnnotationBasedSpringExamples {

	private static final String START_METHOD = "-------Start-------";
	private static final String END_METHOD = "-------End-------";

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(ConfigurationClass.class);
		
		beanNameAwareExample(context);
		beanFactoryAwareExample(context);
		singletonExample(context);
		postConstructAndPreDestroy(context);
		creatingBeanUsingComponentAnnotation(context);
		liteModeBeanExample(context);
		Log.logMessage(SpringVersion.getVersion());
		context.close();
	}
	/**
	 * In the below example {@linkplain LiteModeBeanExample} class
	 * is a bean class and has a method annotated with {@code @Bean}
	 * but as we are calling {@link LiteModeBeanExample#getClass()}
	 * method directly, not using Spring controller so it would not
	 * able to set the dependent data. Hence when we will call
	 * {@link PracticeBean#getPracticeBeanService()} we will get
	 * NullPointerException cause there {@link ServiceBean} object
	 * would be null.
	 * 
	 * @param context
	 */
	private static void liteModeBeanExample(
			AnnotationConfigApplicationContext context) {
		Log.logInfo(START_METHOD);
		LiteModeBeanExample example = context.getBean(
				LiteModeBeanExample.class);
		PracticeBean practiceBean = example.getPracticeBean();
		try {
			
			Log.logMessage(practiceBean.getPracticeBeanService());
		} catch (Exception e) {
			Log.logInfo("Exception wile getting bean service {0}",
					e.getMessage());
		}
		Log.logInfo(END_METHOD);
	}
	private static void creatingBeanUsingComponentAnnotation(
			AnnotationConfigApplicationContext context) {

		Log.logInfo(START_METHOD);
		/* If you see no where we declared the name of the bean
		 * even though it is not throwing any exception but
		 * returning an object. Here if you do not declare any
		 * bean name then by default bean name would be the name
		 * of the class (first letter of the class name would be
		 * in small letter).
		 **/
		ComponentBeanWithoutName object =
				(ComponentBeanWithoutName) context.getBean("componentBeanWithoutName");
		/* If we declare any bean name, then you have to give the
		 * same name of the bean to get the bean object otherwise
		 * it will throw exception.
		 **/
		ComponentBeanWithName object1 =
				(ComponentBeanWithName) context.getBean("anyNameIsFine");
		object.someMethod();
		object1.someMethod();
		Log.logInfo("Bean ID for {0} class is {1}",
				object1.getClass().getSimpleName(),
				object1.getBeanID());
		/* This test will be for those methods
		 * which will get called after the object creation
		 * and before destroying the object.
		 **/
		Log.logInfo(END_METHOD);
	}
	private static void postConstructAndPreDestroy(
			AnnotationConfigApplicationContext context) {

		Log.logInfo(START_METHOD);
		/* This test will be for those methods
		 * which will get called after the object creation
		 * and before destroying the object.
		 **/
		Log.logInfo(END_METHOD);
	}
	/**
	 * This method shows the example of a singleton class.
	 * 
	 */
	private static void singletonExample(AnnotationConfigApplicationContext context) {

		Log.logInfo(START_METHOD);
		SingletonBean object1 = context.getBean("singletonBean", SingletonBean.class);
		SingletonBean object2 = context.getBean("singletonBean", SingletonBean.class);
		Log.logInfo("SingletonBean::object1::hashCode::{0}", object1.hashCode());
		Log.logInfo("SingletonBean::object2::hashCode::{0}", object2.hashCode());
		Log.logInfo(END_METHOD);
	}
	private static void beanFactoryAwareExample(
			AnnotationConfigApplicationContext context) {

		Log.logInfo(START_METHOD);
		BeanFactoryAwareExample beanFactoryAwareExample =
				context.getBean(BeanFactoryAwareExample.class);
		BeanNameAwareExample beanNameAwareExample =
				beanFactoryAwareExample.getBean(BeanNameAwareExample.class);
		Log.logInfo(beanNameAwareExample.toString());
		Log.logInfo(END_METHOD);
	}
	private static void beanNameAwareExample(
			AnnotationConfigApplicationContext context) {
		Log.logInfo(START_METHOD);
		BeanNameAwareExample beanNameAwareExample = context.getBean(BeanNameAwareExample.class);
		Log.logInfo(beanNameAwareExample.toString());
		Log.logInfo(END_METHOD);
	}
}
