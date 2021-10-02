package in.spring.practice.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import in.spring.practice.utils.Log;

public class PostConstructAndPreDestroy {

	public PostConstructAndPreDestroy() {
		Log.logMessage("Inside constructor of " +
				PostConstructAndPreDestroy.class.getSimpleName());
	}
	/**
	 * Methods annotated with {@linkplain PostConstruct} will
	 * be executed after the constructor.
	 */
	@PostConstruct
	public void postConstructMethod1() {
		Log.logMessage("Printing post construct method#1");
	}
	@PostConstruct
	public void postConstructMethod2() {
		Log.logMessage("Printing post construct method#2");
	}
	@PostConstruct
	public void postConstructMethod3() {
		Log.logMessage("Printing post construct method#3");
	}
	@PreDestroy
	public void preDestroyMethod1() {
		Log.logMessage("Printing pre destroy method#1");
	}
	@PreDestroy
	public void preDestroyMethod2() {
		Log.logMessage("Printing pre destroy method#2");
	}
	@PreDestroy
	public void preDestroyMethod3() {
		Log.logMessage("Printing pre destroy method#3");
	}
	/**
	 * Init method will be executed after the method
	 * annotated with {@linkplain PostConstruct}
	 */
	public void initMethod() {
		Log.logMessage("Printing init method");
	}
	/**
	 * Destroy method will be executed after the method
	 * annotated with {@linkplain PreDestroy}
	 */
	public void destroyMethod() {
		Log.logMessage("Printing destroy method");
	}
}
