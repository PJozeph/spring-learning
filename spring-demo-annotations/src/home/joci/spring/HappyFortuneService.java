package home.joci.spring;

import org.springframework.stereotype.Component;

@Component("happyFortuneService")
public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "This is you best day is your life";
	}

}
