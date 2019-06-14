package spring.joci.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLoggingDemoAspect {

//	@Before("execution (public void add*())")
//	(..) -> any parameter
	@Before("execution (* spring.joci.aop.*.*(..))")
	public void beforeAddAcountAdvice() {
		System.err.println("========>> Executing before advice ");
	}
	
}
