package home.joci.spring;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;
	
	public TrackCoach() {}
	
	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	public void init() {
		System.out.println("TrackCoach: inside in init method");
	}

	public void destroy() {
		System.out.println("TrackCoach: inside in destory method");
	}
	
}
