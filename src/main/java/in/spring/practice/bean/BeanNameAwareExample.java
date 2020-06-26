package in.spring.practice.bean;

import org.springframework.beans.factory.BeanNameAware;

import in.spring.practice.utils.Log;

public class BeanNameAwareExample implements BeanNameAware {

	public void setBeanName(String name) {
		Log.logInfo("Bean name is {0}", name);
	}
}
