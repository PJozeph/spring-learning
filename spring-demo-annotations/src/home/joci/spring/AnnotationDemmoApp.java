package home.joci.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemmoApp {

	public static void main(String[] args) {
		
		// read the spring config file 
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve the bean from the bean container 
		Coach coach = context.getBean("baseballCoach",Coach.class);
		
		System.err.println(coach.getDailyWorkout());
		System.err.println(coach.getDailyFortune());
		
		//close the spring container
		context.close();
		
	}
}
