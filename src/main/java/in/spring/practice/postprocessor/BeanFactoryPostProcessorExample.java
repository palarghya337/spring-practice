package in.spring.practice.postprocessor;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import in.spring.practice.bean.PrintSomeMessage;

public class BeanFactoryPostProcessorExample implements BeanFactoryPostProcessor {

	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) {
		
		PrintSomeMessage printMessage = beanFactory.getBean("printSomeMessage", PrintSomeMessage.class);
		printMessage.setSomeMessage("New message set inside BeanFactoryPostProcessor");
	}
}
