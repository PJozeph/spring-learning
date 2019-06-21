package spring.joci.aop.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.joci.aop.demo.service.TrafficFortuneService;

public class AroundExceptionDemoApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(DemoConfig.class);

		TrafficFortuneService trafficFortuneService = container.getBean(TrafficFortuneService.class);
		
		String fortune = trafficFortuneService.getFortune(true);
		System.out.println(fortune);

		container.close();
	}

}
