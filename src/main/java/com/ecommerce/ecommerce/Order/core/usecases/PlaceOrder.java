package com.ecommerce.ecommerce.Order.core.usecases;

import com.ecommerce.ecommerce.Catalog.core.domain.category.CategoryId;
import com.ecommerce.ecommerce.Order.core.domain.Order.Order;
import com.ecommerce.ecommerce.Order.core.domain.Order.OrderId;
import com.ecommerce.ecommerce.Order.core.repositories.OrderRepository;

import java.util.UUID;

public class PlaceOrder {
    private final OrderRepository orderRepository;
    public PlaceOrder(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    void execute(Order order) {
        order.setPending();
        if (order.getId() == null) {
            order.setId(new OrderId(UUID.randomUUID().toString()));
        }
        this.orderRepository.save(order);
    }
}
