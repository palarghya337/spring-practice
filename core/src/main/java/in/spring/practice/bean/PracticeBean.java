package in.spring.practice.bean;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.spring.practice.utils.Log;

@Component
public class PracticeBean {

	@Autowired
	private ServiceBean serviceBean;
	
	public PracticeBean() {
		Log.logInfo("Inside constructor of {0} class",
				PracticeBean.class.getSimpleName());
	}
	public String getPracticeBeanService() {
		Objects.requireNonNull(serviceBean);
		return serviceBean.getSomeService();
	}
}
