package home.joci.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("home.joci.spring")
// use bean that are manually defined
@PropertySource("classpath:sport.properties")
public class SportConfig {

		//define a bean for sadFortuneService
		@Bean
		public FortuneService sadFortuneService() {
			return new SadFortuneService();
		}
		
		// define bean for swim coach and inject its dependency
		@Bean
		public Coach swimCoach() {
			return new SwimCoach(sadFortuneService());
		}
	
}
