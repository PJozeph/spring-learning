package spring.joci.aop.demo.service;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {

	public String getFortune(boolean exception) {
		if(exception) {
			throw new RuntimeException("Something is wrong");
		}

		return "Expect heavy traffc";
	}

}
