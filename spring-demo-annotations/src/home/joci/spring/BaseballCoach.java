package home.joci.spring;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class BaseballCoach implements Coach {

	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	public BaseballCoach() {
		System.out.println("BaseballCoach: inside in no-args constructor");
	}
	
	@Override
	public String getDailyWorkout() {
		return "As a warm up do 5 * 20 sqad";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	@PostConstruct
	public void init() {
		System.out.println("BaseballCoach: inside in init method");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("BaseballCoach: inside in destroy method");
	}

}
