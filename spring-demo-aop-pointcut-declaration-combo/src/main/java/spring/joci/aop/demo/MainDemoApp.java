package spring.joci.aop.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.joci.aop.Account;
import spring.joci.aop.AccountDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO accountDao = container.getBean(AccountDAO.class);
		
		Account account = new Account("Pallagi","József");
		account.getFristname();

		accountDao.addAccount(account,true);
		container.close();
	}

}
