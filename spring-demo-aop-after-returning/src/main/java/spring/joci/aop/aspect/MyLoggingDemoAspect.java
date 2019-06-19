package spring.joci.aop.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import spring.joci.aop.Account;

@Aspect
@Component
public class MyLoggingDemoAspect {

	@AfterReturning(pointcut="execution (* spring.joci.aop.AccountDAO.findAccounts(..))",returning="result")
	public void afterReturningAdvice(JoinPoint joinPoint, List<Account> result) {
		System.out.println("Executing @Afterreturning on findAccounts");
		//post-process the data
		result.forEach(e-> e.setFristname(e.getFristname().toUpperCase()));
	}
	
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
