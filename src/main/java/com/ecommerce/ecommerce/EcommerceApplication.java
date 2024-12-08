package com.ecommerce.ecommerce;

import com.ecommerce.ecommerce.Shared.core.events.EventPublisher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

	@Bean
	EventPublisher eventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		return applicationEventPublisher::publishEvent;
	}
}
