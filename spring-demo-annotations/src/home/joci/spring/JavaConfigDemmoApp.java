package home.joci.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemmoApp {

	public static void main(String[] args) {
		
		// read the spring java config class 
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		// retrieve the bean from the bean container 
		Coach coach = context.getBean("baseballCoach",Coach.class);
		
		System.err.println(coach.getDailyWorkout());
		System.err.println(coach.getDailyFortune());
		
		//close the spring container
		context.close();
		
	}
}
