package in.spring.practice.configuration;

import in.spring.practice.bean.TempBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TempConfiguration {

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public TempBean getTempBean() {
        return new TempBean();
    }
}
