package in.spring.practice.lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configurations {

	@Bean(initMethod = "init", destroyMethod = "destroy")
	public UserBean getUserBean() {
		return new UserBean();
	}
	
	@Bean
	public BeanPostProcessorImpl getBeanPostProcessor() {
		return new BeanPostProcessorImpl();
	}
}
