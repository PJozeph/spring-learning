package home.joci.spring;

public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "This is your lucky day man!!";
	}

}
