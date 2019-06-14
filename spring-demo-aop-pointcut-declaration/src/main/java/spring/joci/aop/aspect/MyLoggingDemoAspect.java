package spring.joci.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLoggingDemoAspect {

	@Pointcut("execution (* spring.joci.aop.*.*(..))")
	public void forDaoPackage() {}
	
	@Before("forDaoPackage()")
	public void beforeAddAcountAdvice() {
		System.err.println("========>> Executing before advice ");
	}
	
	
}
