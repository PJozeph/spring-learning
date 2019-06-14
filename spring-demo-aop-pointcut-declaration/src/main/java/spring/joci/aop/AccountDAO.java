package spring.joci.aop;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

	public void addAccount(Account account, boolean vipFlag) {
		System.out.println(getClass() + "DO MY DB WORK ");
	}
	
	public boolean doWork() {
		System.out.println(getClass() + "DOING MY DB WORK ");
		return true;
	}
}
