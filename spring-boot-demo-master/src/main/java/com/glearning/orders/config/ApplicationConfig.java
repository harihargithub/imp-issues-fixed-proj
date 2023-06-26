package com.glearning.orders.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
	
	//programmatic way of creating a spring bean
	@ConditionalOnProperty(value = "loadUser", prefix = "app", havingValue = "false")
	@Bean
	public User user() {
		return new User();
	}
	
	@ConditionalOnBean(name="user")
	@Bean
	public User userBeanBasedOnBean() {
		return new User();
	}
	
	@ConditionalOnMissingBean(name="user")
	@Bean
	public User userBeanBasedOnMissingssBean() {
		return new User();
	}
	
	@ConditionalOnClass(name = "com.glearning.orders.util.ApplicationUtil")
	@Bean
	public User userBeanBasedOnClass() {
		return new User();
	}
	
	@ConditionalOnMissingClass(value =  "x.y.z")
	@Bean
	public User userBeanBasedOnMissingClass() {
		return new User();
	}

}
