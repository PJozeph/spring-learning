package spring.joci.aop.demo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.joci.aop.Account;
import spring.joci.aop.AccountDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO accountDao = container.getBean(AccountDAO.class);

		List<Account> findAccounts = accountDao.findAccounts();
		System.out.println("===> Main class");
		findAccounts.forEach(System.out::println);
		
		container.close();
	}

}
