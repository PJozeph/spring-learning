package spring.joci.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyLoggingDemoAspect {

	@Before("spring.joci.aop.aspect.AopExpressions.forDaoPackageNoGetterAndSetter()")
	public void beforeAddAcountAdvice() {
		System.err.println("========>> Executing before advice ");
	}
	
}
