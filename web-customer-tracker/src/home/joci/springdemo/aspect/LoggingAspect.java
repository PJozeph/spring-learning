package home.joci.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	// set logger
	private Logger logger = Logger.getLogger(getClass().getName());

	@Pointcut("execution (* home.joci.springdemo.controller.*.*(..))")
	public void forControllerPackage() {
	}

	@Pointcut("execution (* home.joci.springdemo.service.*.*(..))")
	public void forServicePackage() {
	}

	@Pointcut("execution (* home.joci.springdemo.dao.*.*(..))")
	public void forsDaoPackage() {
	}

	@Pointcut("forControllerPackage() || forServicePackage() || forsDaoPackage()")
	public void forAppFlow() {
	};

	@Before("forAppFlow()")
	public void beforeAppFlow(JoinPoint jointpoint) {
		logger.info("in @Before: calling method : " + jointpoint.getSignature().toString());

		Object [] argument = jointpoint.getArgs();
		for (Object object : argument) {
			logger.info("argument -->" +object );
		}
	}

}
