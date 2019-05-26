package home.joci.spring;

public class SadFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Today is your sad day :(";
	}

}
