package in.spring.practice.profile;

public interface OperatingSystem {

	enum Type {
		IOS("ios"), Windows("windows");
		String value;
		Type (String value) {
			this.value = value;
		}
	}
	String getCompanyName();
}
