package spring.joci.aop;

import java.util.Arrays;
import java.util.List;

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
	
	public List<Account> findAccounts(boolean isException) throws Exception {
		if (isException) {
			throw new Exception("No food for you!!");
		}
		return Arrays.asList(new Account("Jhon", "Doe")
				,new Account("Pallagi", "József")
				,new Account("Big", "Denny"));
	}
}
