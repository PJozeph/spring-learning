package spring.joci.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

	@Pointcut("execution (* spring.joci.aop.*.*(..))")
	public void forDaoPackage() {}
	
	@Pointcut("execution (* spring.joci.aop.*.get*(..))")
	public void getter() {}
	
	@Pointcut("execution (* spring.joci.aop.*.set*(..))")
	public void setter() {}

	@Pointcut("forDaoPackage() && !(getter() && setter())")
	public void forDaoPackageNoGetterAndSetter() {}
	
}
