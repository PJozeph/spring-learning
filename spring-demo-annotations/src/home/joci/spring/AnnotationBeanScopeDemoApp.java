package home.joci.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// retrieve the bean from the bean container
		Coach coach = context.getBean("baseballCoach", Coach.class);

		Coach coachTwo = context.getBean("baseballCoach", Coach.class);

		System.out.println(coach.equals(coachTwo));

	}
}
