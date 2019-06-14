package spring.joci.aop.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.joci.aop.Account;
import spring.joci.aop.AccountDAO;
import spring.joci.aop.MemeberShipDAO;
import spring.joci.aop.StudentDAO;

public class MainDemoApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(DemoConfig.class);

		AccountDAO accountDao = container.getBean(AccountDAO.class);
		MemeberShipDAO membershipDao = container.getBean(MemeberShipDAO.class);
		StudentDAO studentDao = container.getBean(StudentDAO.class);

		accountDao.addAccount(new Account(), true);
		accountDao.doWork();
		membershipDao.addAccount();
		membershipDao.goToSleep();
		studentDao.addStudent();

		container.close();
	}

}
