package home.joci.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemmoApp {

	public static void main(String[] args) {
		
		// read the spring java config class 
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		// retrieve the bean from the bean container 
		SwimCoach coach = context.getBean("swimCoach",SwimCoach.class);
		
		System.err.println(coach.getDailyWorkout());
		System.err.println(coach.getDailyFortune());
		
		System.err.println(coach.getEmail());
		System.err.println(coach.getTeam());
		
		//close the spring container
		context.close();
		
	}
}
