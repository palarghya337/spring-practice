package in.spring.practice.lifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LifeCycleTest {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(
						Configurations.class);
		context.getBean(UserBean.class);
		context.close();
	}
}
