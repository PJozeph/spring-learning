package spring.joci.aop;

import org.springframework.stereotype.Component;

@Component
public class MemeberShipDAO {

	public void addAccount() {
		System.out.println(getClass() + " : ADDING MEMBERSHIP ACCOUNT");
	}
	
	public void goToSleep() {
		System.out.println(getClass() + " : GOING TO SLEEP");
	}
}
