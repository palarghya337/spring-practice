package in.spring.practice.profile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile(value = "windows")
public class Windows implements OperatingSystem {

	private static final String CLASS_NAME = Windows
			.class.getSimpleName();
	
	public Windows() {
		System.out.println(CLASS_NAME + ": constructor");
	}
	@Override
	public String getCompanyName() {
		return "Microsoft";
	}

}
