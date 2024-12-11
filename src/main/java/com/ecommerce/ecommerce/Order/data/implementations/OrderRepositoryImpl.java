package com.ecommerce.ecommerce.Order.data.implementations;

import com.ecommerce.ecommerce.Order.core.domain.Order.Order;
import com.ecommerce.ecommerce.Order.core.domain.Order.OrderId;
import com.ecommerce.ecommerce.Order.core.domain.Order.UserId;
import com.ecommerce.ecommerce.Order.core.repositories.OrderRepository;
import com.ecommerce.ecommerce.Order.data.JpaRepositories.JpaOrderRepository;
import com.ecommerce.ecommerce.Order.data.entities.OrderEntity;
import com.ecommerce.ecommerce.Order.data.mappers.OrderMapper;
import com.ecommerce.ecommerce.Shared.core.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public class OrderRepositoryImpl implements OrderRepository {

    private final JpaOrderRepository orderRepository;
    // inject JpaRepository to simplify requests
    public OrderRepositoryImpl(JpaOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order save(Order order) {
        var ord = orderRepository.save(OrderMapper.toEntity(order));
        return OrderMapper.toDomain(ord);
    }

    @Override
    public Optional<Order> findById(OrderId id) {
        Optional<OrderEntity> response = orderRepository.findById(id.getValue());
        return response.map(OrderMapper::toDomain);
    }

    @Override
    public Page<Order> findByUserId(UserId id, int size, int page) {
        Pageable pageable = PageRequest.of(page, size);

        var orderEntities = orderRepository.findByUserId(id.getValue(), pageable);

        List<Order> orders = orderEntities.getContent().stream()
                .map(OrderMapper::toDomain)
                .toList();

        return new Page<>(orderEntities.getTotalPages(),orderEntities.getNumberOfElements(),orders);
    }

    @Override
    public Page<Order> findByStatus(Order.Status status, int size, int page, UserId userId) {
        Pageable pageable = PageRequest.of(page, size);
        if (userId != null) {
            var orderEntities = orderRepository.findByStatusAndUserId(status.toString(), pageable,userId.getValue());

            List<Order> orders = orderEntities.getContent().stream()
                    .map(OrderMapper::toDomain)
                    .toList();

            return new Page<>(orderEntities.getTotalPages(), orderEntities.getNumberOfElements(), orders);
        } else {
            var orderEntities = orderRepository.findByStatus(status.toString(), pageable);

            List<Order> orders = orderEntities.getContent().stream()
                    .map(OrderMapper::toDomain)
                    .toList();

            return new Page<>(orderEntities.getTotalPages(), orderEntities.getNumberOfElements(), orders);
        }
    }
}
