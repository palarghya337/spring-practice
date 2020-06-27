package in.spring.practice.profile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile(value = "ios")
public class IOS implements OperatingSystem {

	private static final String CLASS_NAME = IOS
			.class.getSimpleName();
	
	public IOS() {
		System.out.println(CLASS_NAME + ": constructor");
	}
	@Override
	public String getCompanyName() {
		return "Apple";
	}

}
