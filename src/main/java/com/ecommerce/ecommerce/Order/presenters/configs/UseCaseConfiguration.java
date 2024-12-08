package com.ecommerce.ecommerce.Order.presenters.configs;

import com.ecommerce.ecommerce.Order.core.repositories.OrderRepository;
import com.ecommerce.ecommerce.Order.core.usecases.FindOrderById;
import com.ecommerce.ecommerce.Order.core.usecases.FindOrderByStatus;
import com.ecommerce.ecommerce.Order.core.usecases.FindOrderByUserId;
import com.ecommerce.ecommerce.Order.core.usecases.PlaceOrder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("orderUseCaseConfiguration")
public class UseCaseConfiguration {

    @Bean
    public FindOrderById findOrderByIdUseCase(OrderRepository orderRepository) {
        return new FindOrderById(orderRepository);
    }
    @Bean
    public PlaceOrder placeOrderUseCase(OrderRepository orderRepository) {
        return new PlaceOrder(orderRepository);
    }
    @Bean
    public FindOrderByStatus findOrderByStatusUseCase(OrderRepository orderRepository) {
        return new FindOrderByStatus(orderRepository);
    }
    @Bean
    public FindOrderByUserId findOrderByUserIdUseCase(OrderRepository orderRepository) {
        return new FindOrderByUserId(orderRepository);
    }
}
