package spring.joci.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class MyLoggingDemoAspect {

	@Around("execution (* spring.joci.aop.demo.service.*.getFortune(..))")
	public Object aroundGetObject(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("Executing Around Advice");
		StopWatch watch = new StopWatch();
		watch.start();
		
		proceedingJoinPoint.proceed();
		
		watch.stop();
		
		System.out.println("getFortune service executed in " + watch.getTotalTimeSeconds());
		
		return null;
	}
	
	
	@After("execution (* spring.joci.aop.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
		System.out.println("Executing After finnaly on method : " + joinPoint.getSignature().toShortString());
	}
	

}
