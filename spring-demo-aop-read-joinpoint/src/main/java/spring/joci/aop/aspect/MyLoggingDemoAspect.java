package spring.joci.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyLoggingDemoAspect {

	@Before("spring.joci.aop.aspect.AopExpressions.forDaoPackageNoGetterAndSetter()")
	public void beforeAddAcountAdvice(JoinPoint joinPoint) {
		
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		System.out.println("Method : " + methodSignature);
		
		Object[] arguments = joinPoint.getArgs();
		for (Object object : arguments) {
			System.out.println(object);
		}

	}

}
