package home.joci.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {

	
	public static void main(String[] args) {
		
		//load the spring config 
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLifeCycleApplicationContext.xml");
		
		// retrieve bean from spring container
		Coach secondCoach = context.getBean("myCoach",Coach.class);
		
		context.close();
		
	}
}
