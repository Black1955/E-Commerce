package com.ecommerce.ecommerce.Order.core.usecases;

import com.ecommerce.ecommerce.Order.core.domain.Order.Order;
import com.ecommerce.ecommerce.Order.core.domain.Order.UserId;
import com.ecommerce.ecommerce.Order.core.repositories.OrderRepository;
import com.ecommerce.ecommerce.Shared.Page;

public class FindOrderByUserId {
    private final OrderRepository orderRepository;

    private static final int DEFAULT_SIZE = 10;
    private static final int DEFAULT_PAGE = 0;

    public FindOrderByUserId(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    /**
     * Finds orders by user ID with default pagination settings.
     *
     * @param userId The ID of the user whose orders are being retrieved.
     * @return A page of orders.
     */
    public Page<Order> execute(UserId userId) {
        return execute(userId, DEFAULT_SIZE, DEFAULT_PAGE);
    }

    /**
     * Finds orders by user ID with specified pagination settings.
     *
     * @param userId The ID of the user whose orders are being retrieved.
     * @param size   The number of items per page (must be greater than 0).
     * @param page   The page number (must be 0 or greater).
     * @return A page of orders.
     * @throws IllegalArgumentException if size or page values are invalid.
     */
    public Page<Order> execute(UserId userId, int size, int page) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be greater than 0.");
        }
        if (page < 0) {
            throw new IllegalArgumentException("Page must be 0 or greater.");
        }

        return orderRepository.findByUserId(userId, size, page);
    }
}
