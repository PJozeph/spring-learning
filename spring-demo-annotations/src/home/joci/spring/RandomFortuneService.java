package home.joci.spring;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		List<String> fortunes = Arrays.asList("Today some will visit you!","You better stay at home",
				"Your boss will raise your salary","You will be fire today :(");
		return fortunes.get(new Random().nextInt(fortunes.size()));
	}

}
