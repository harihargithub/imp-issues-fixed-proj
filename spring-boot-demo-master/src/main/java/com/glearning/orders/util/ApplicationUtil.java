package com.glearning.orders.util;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ApplicationUtil implements CommandLineRunner {
	
	@Autowired
	private ApplicationContext applicationContext;

	@Override
	public void run(String... args) throws Exception {
		String beanNames[] = this.applicationContext.getBeanDefinitionNames();
		
		//imperative
		
		/*
		 for(int i =0; i < beanNames.length; i++) {
			 if(beanNames[i].startsWith("user")) {
				 System.out.println(beanNames[i]);
			 }
		 
		 }*/
		
		//declarative style of programming
		Stream.of(beanNames)
			.filter(beanName -> beanName.startsWith("user"))
			.forEach(bean -> System.out.println(bean));
		
	}

}
