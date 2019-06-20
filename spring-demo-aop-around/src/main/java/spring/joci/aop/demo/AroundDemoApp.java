package spring.joci.aop.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.joci.aop.demo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(DemoConfig.class);

		TrafficFortuneService trafficFortuneService = container.getBean(TrafficFortuneService.class);
		
		trafficFortuneService.getFortune();

		container.close();
	}

}
