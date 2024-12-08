package com.ecommerce.ecommerce.Order.presenters.configs;

import com.ecommerce.ecommerce.Order.core.repositories.OrderRepository;
import com.ecommerce.ecommerce.Order.data.JpaRepositories.JpaOrderRepository;
import com.ecommerce.ecommerce.Order.data.implementations.OrderRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("orderRepositoryConfiguration")
public class RepositoryConfiguration {

    @Bean
    public OrderRepository orderRepository(JpaOrderRepository jpaOrderRepository) {
        return new OrderRepositoryImpl(jpaOrderRepository);
    }

}
