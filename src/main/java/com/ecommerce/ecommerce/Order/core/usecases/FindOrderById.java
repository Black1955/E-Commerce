package com.ecommerce.ecommerce.Order.core.usecases;

import com.ecommerce.ecommerce.Order.core.domain.Order.Order;
import com.ecommerce.ecommerce.Order.core.domain.Order.OrderId;
import com.ecommerce.ecommerce.Order.core.repositories.OrderRepository;

import java.util.Optional;

public class FindOrderById {
    private final OrderRepository orderRepository;
    public FindOrderById(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
   public Optional<Order> execute(OrderId id) {
        return orderRepository.findById(id);
    }
}
