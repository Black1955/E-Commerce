package com.ecommerce.ecommerce.Order.core.usecases;

import com.ecommerce.ecommerce.Order.core.domain.Order.Order;
import com.ecommerce.ecommerce.Order.core.repositories.OrderRepository;
import com.ecommerce.ecommerce.Shared.Page;

public class FindOrderByStatus {
    private final OrderRepository orderRepository;

    public static int DEFAULT_SIZE = 10;
    public static int DEFAULT_PAGE = 0;

    public FindOrderByStatus(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    Page<Order> execute(Order.Status status) {
        return this.execute(status, DEFAULT_SIZE,DEFAULT_PAGE);
    }
    Page<Order> execute(Order.Status status, int size, int page) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be greater than 0.");
        }
        if (page < 0) {
            throw new IllegalArgumentException("Page must be 0 or greater.");
        }
        return this.orderRepository.findByStatus(status,DEFAULT_SIZE,DEFAULT_PAGE);
    }

}
