package in.spring.practice.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import in.spring.practice.utils.Log;

@Component
public class InitAndDestroyBeanImpl implements InitializingBean, DisposableBean {

	public InitAndDestroyBeanImpl() {
		Log.logMessage("InitAndDestroyBeanImpl() constructor");
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		Log.logInfo("afterPropertiesSet() method of {0} class executed.",
				getClass().getSimpleName());
	}

	@Override
	public void destroy() throws Exception {
		Log.logInfo("destroy() method of {0} class executed",
				getClass().getSimpleName());
	}
}
