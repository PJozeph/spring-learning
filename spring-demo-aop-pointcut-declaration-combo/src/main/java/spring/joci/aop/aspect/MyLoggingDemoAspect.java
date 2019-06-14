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
	
	@Pointcut("execution (* spring.joci.aop.*.get*(..))")
	public void getter() {}
	
	@Pointcut("execution (* spring.joci.aop.*.set*(..))")
	public void setter() {}
	
	@Before("forDaoPackage()")
	public void beforeAddAcountAdvice() {
		System.err.println("========>> Executing before advice ");
	}
	
	@Pointcut("forDaoPackage() && !(getter() && setter())")
	public void forDaoPackageNoGetterAndSetter() {}
	
	@Before("forDaoPackage() && forDaoPackageNoGetterAndSetter() ")
	public void performApiAnalytics() {
		System.err.println("========>> Executing API analytics ");
	}
	
	
}
