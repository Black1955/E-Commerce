package com.ecommerce.ecommerce.Order.core.repositories;

import com.ecommerce.ecommerce.Order.core.domain.Order.Order;
import com.ecommerce.ecommerce.Order.core.domain.Order.OrderId;
import com.ecommerce.ecommerce.Order.core.domain.Order.UserId;
import com.ecommerce.ecommerce.Shared.Page;
import java.util.Optional;

public interface OrderRepository {
    void save(Order order);
    Optional<Order> findById(OrderId id);
    Page<Order> findByUserId(UserId id, int size, int page);
    Page<Order> findByStatus(Order.Status status, int size, int page);
}
