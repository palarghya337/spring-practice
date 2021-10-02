package in.spring.practice.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class LiteModeBeanExample {

	/**
	 * <h3>{@code @Bean} <em>Lite</em> Mode</h3>
	 *
	 * <p>{@code @Bean} methods may also be declared within classes that are <em>not</em>
	 * annotated with {@code @Configuration}. For example, bean methods may be declared
	 * in a {@code @Component} class or even in a <em>plain old class</em>. In such cases,
	 * a {@code @Bean} method will get processed in a so-called <em>'lite'</em> mode.
	 *
	 * <p>Bean methods in <em>lite</em> mode will be treated as plain <em>factory
	 * methods</em> by the container (similar to {@code factory-method} declarations
	 * in XML), with scoping and lifecycle callbacks properly applied. The containing
	 * class remains unmodified in this case, and there are no unusual constraints for
	 * the containing class or the factory methods.
	 *
	 * <p>In contrast to the semantics for bean methods in {@code @Configuration} classes,
	 * <em>'inter-bean references'</em> are not supported in <em>lite</em> mode. Instead,
	 * when one {@code @Bean}-method invokes another {@code @Bean}-method in <em>lite</em>
	 * mode, the invocation is a standard Java method invocation; Spring does not intercept
	 * the invocation via a CGLIB proxy. This is analogous to inter-{@code @Transactional}
	 * method calls where in proxy mode, Spring does not intercept the invocation &mdash;
	 * Spring does so only in AspectJ mode.
	 * @return
	 */
	@Bean
	public PracticeBean getPracticeBean() {
		return new PracticeBean();
	}
}
