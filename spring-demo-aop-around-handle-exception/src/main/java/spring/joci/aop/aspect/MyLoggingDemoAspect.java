package spring.joci.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLoggingDemoAspect {

	@Around("execution (* spring.joci.aop.demo.service.*.getFortune(..))")
	public Object aroundGetObject(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		Object result = null;
		try {
			result = proceedingJoinPoint.proceed();
		} catch (Exception e) {
			System.out.println("Handling exception in AOP @Around level --> " + e.getMessage());
			result = "Do not worry exception was handled in AOP level";
		}
		return result;
	}

}
