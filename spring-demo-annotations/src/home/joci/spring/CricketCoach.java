package home.joci.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

	private FortuneService fortuneService;
	
	public CricketCoach() {
		System.out.println("CricketCoach: inside no-args constructor");
	}
	
	@Override
	public String getDailyWorkout() {
		return "Do 80 burpee";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	@Autowired
	@Qualifier("restFortuneService")
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach: inside setFrtuneService method");
		this.fortuneService = fortuneService;
	}

}
