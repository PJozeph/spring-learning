package home.joci.spring;

import org.springframework.stereotype.Component;

@Component("restFortuneService")
public class RESTfortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return null;
	}

}
