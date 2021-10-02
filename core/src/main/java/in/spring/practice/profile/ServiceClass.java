package in.spring.practice.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceClass {

	@Autowired
	private OperatingSystem operatingSystem;
	
	public String getCompany() {
		return operatingSystem.getCompanyName();
	}
}
