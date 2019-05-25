package home.joci.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	
	public static void main(String[] args) {
		
		// load the spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve the bean from the spring container
		CricketCoach coach = context.getBean("cricketCoach",CricketCoach.class);
		
		// use the bean
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());
		
		System.out.print("The coach's team and email: ");
		System.out.print(coach.getEmail());
		System.out.print(coach.getTeam());
		
		//close context
		context.close();
	}
	
}
