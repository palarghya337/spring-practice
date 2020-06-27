package in.spring.practice.profile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.AbstractEnvironment;

public class ProfileTest {

	public static void main(String[] args) {
		
		System.setProperty(AbstractEnvironment
				.ACTIVE_PROFILES_PROPERTY_NAME,
				OperatingSystem.Type.Windows.value);
		
		String packageName = ProfileTest.class.getPackage().getName();
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(packageName);
		ServiceClass os = context.getBean(ServiceClass.class);
		System.out.println("Company Name: " + os.getCompany());
		context.close();
	}
}
