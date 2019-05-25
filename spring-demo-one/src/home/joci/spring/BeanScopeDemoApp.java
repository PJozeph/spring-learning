package home.joci.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	
	public static void main(String[] args) {
		
		//load the spring config 
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScopeApplicationContext.xml");
		
		// retrieve bean from spring container
		Coach firstCoach = context.getBean("myCoach",Coach.class);
		Coach secondCoach = context.getBean("myCoach",Coach.class);
		
		// check if the two bean are the same
		System.out.println(firstCoach.equals(secondCoach));
		// by default it is singleton
		// if the bean scope is prototype, spring create new instance for each request, so the two object are not the same
		context.close();
		
	}
}
