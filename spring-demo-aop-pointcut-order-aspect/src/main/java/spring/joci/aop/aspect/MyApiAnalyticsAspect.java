package spring.joci.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {
	
	@Before("spring.joci.aop.aspect.AopExpressions.forDaoPackageNoGetterAndSetter()")
	public void performApiAnalytics() {
		System.err.println("========>> Executing API analytics ");
	}	
	
}
