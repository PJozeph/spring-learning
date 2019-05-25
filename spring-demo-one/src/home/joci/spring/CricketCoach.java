package home.joci.spring;

public class CricketCoach implements Coach {

	private String email;
	private String team;
	
	private FortuneService fortuneService;
	
	public CricketCoach() {
		System.out.println("CricketCoach: inside no-arg constructor");
	}
	
	@Override
	public String getDailyWorkout() {
		return "Practice fast passing for half hour";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CrickerCoach: inside setFortuneService method ");
		this.fortuneService = fortuneService;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		System.out.println("CricketCoach: inside setEmai method");
		this.email = email;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		System.out.println("CricketCoach: inside setTeam method");
		this.team = team;
	}

}
