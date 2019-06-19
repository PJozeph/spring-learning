package spring.joci.aop.demo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.joci.aop.Account;
import spring.joci.aop.AccountDAO;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(DemoConfig.class);

		AccountDAO accountDao = container.getBean(AccountDAO.class);

		try {
			List<Account> findAccounts = accountDao.findAccounts(true);
			findAccounts.forEach(System.out::println);
		} catch (Exception e) {
			System.out.println("===> Main class exception handling");
		}


		container.close();
	}

}
