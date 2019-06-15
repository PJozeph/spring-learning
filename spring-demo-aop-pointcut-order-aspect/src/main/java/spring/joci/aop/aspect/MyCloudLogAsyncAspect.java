package spring.joci.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyCloudLogAsyncAspect {
	
	@Before("spring.joci.aop.aspect.AopExpressions.forDaoPackageNoGetterAndSetter()")
	public void logToCloudAsync() {
		System.err.println("========>> Logging to cloud");
	}
	
}
