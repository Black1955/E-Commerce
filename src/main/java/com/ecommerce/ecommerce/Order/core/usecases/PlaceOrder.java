package com.ecommerce.ecommerce.Order.core.usecases;

import com.ecommerce.ecommerce.Catalog.core.domain.category.CategoryId;
import com.ecommerce.ecommerce.Order.core.domain.Order.Order;
import com.ecommerce.ecommerce.Order.core.domain.Order.OrderId;
import com.ecommerce.ecommerce.Order.core.repositories.OrderRepository;

import java.util.UUID;

/**
 * create Order use case
 */
public class PlaceOrder {
    private final OrderRepository orderRepository;

    //inject repository for Order to save it in a database
    public PlaceOrder(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    public Order execute(Order order) {
        order.setPending(); // set pending status for Order

        // When user places an order, this order does not have ID,
        // that is why I create it here.
        if (order.getId() == null) {
            order.setId(new OrderId(UUID.randomUUID().toString()));
        }
        return this.orderRepository.save(order);
    }
}
