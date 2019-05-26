package home.joci.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// default bean id will be -> tennisCoach
@Component
public class TennisCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public TennisCoach() {
		System.out.println("TennisCoach: inside no-args constructor");
	}

	@Autowired
	public TennisCoach(@Qualifier("dbFortuneService")FortuneService fortuneService) {
		this.fortuneService = fortuneService;
		System.out.println("TennisCoach: inside one-param constrctor");
	}

	@Override
	public String getDailyWorkout() {
		return "Practice serving for 20 minutes";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
