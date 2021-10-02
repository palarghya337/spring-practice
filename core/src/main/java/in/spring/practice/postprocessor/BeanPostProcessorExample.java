package in.spring.practice.postprocessor;

import java.text.MessageFormat;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import in.spring.practice.bean.Employee;
import in.spring.practice.bean.PrintSomeMessage;
import in.spring.practice.utils.Log;

public class BeanPostProcessorExample implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) {
		
		Log.logMessage(beanName);
		if (bean instanceof PrintSomeMessage) {
			
			String newMessage = "Adding new message";
			PrintSomeMessage messageBean = (PrintSomeMessage) bean;
			Log.logMessage(MessageFormat
					.format("Changing message from ''{0}'' to ''{1}''",
							messageBean.getSomeMessage(), newMessage));
			messageBean.setSomeMessage(newMessage);
		} else if (bean instanceof Employee) {
			
			String newName = "Shovan Chakraborty";
			Employee employee = (Employee) bean;
			Log.logMessage(MessageFormat
					.format("Changing name from ''{0}'' to ''{1}''",
							employee.getName(), newName));
			employee.setName(newName);
		}
		return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
	}
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

		Log.logMessage(beanName);
		if (bean instanceof PrintSomeMessage) {
			
			String newMessage = "Deleting new message";
			PrintSomeMessage messageBean = (PrintSomeMessage) bean;
			Log.logMessage(MessageFormat
					.format("Changing message from ''{0}'' to ''{1}''",
							messageBean.getSomeMessage(), newMessage));
			messageBean.setSomeMessage(newMessage);
		} else if (bean instanceof Employee) {
			
			String newName = "Gulugulu";
			Employee employee = (Employee) bean;
			Log.logMessage(MessageFormat
					.format("Changing name from ''{0}'' to ''{1}''",
							employee.getName(), newName));
			((Employee) bean).setName(newName);
		}
		return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
	}
}
