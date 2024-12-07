package com.ecommerce.ecommerce.Order.data.mappers;

import com.ecommerce.ecommerce.Order.core.domain.Order.Order;
import com.ecommerce.ecommerce.Order.core.domain.Order.OrderId;
import com.ecommerce.ecommerce.Order.core.domain.Order.Price;
import com.ecommerce.ecommerce.Order.core.domain.Order.UserId;
import com.ecommerce.ecommerce.Order.data.entities.OrderEntity;

public class OrderMapper {
    public static OrderEntity toEntity(Order order) {
        return new OrderEntity(
                order.getId() != null ? order.getId().getValue() : null,
                order.getUserId().getValue(),
                order.getOrderDate(),
                order.getStatus().toString(),
                AdressMapper.toEmbeddable(order.getAdress()),
                order.getItems().stream()
                        .map(OrderItemMapper::toEmbeddable)
                        .toList(),
                order.getPrice().getValue()
        );
    }

    public static Order toDomain(OrderEntity entity) {
        return new Order(
                new OrderId(entity.getId()),
                new UserId(entity.getUserId()),
                entity.getOrderItems().stream()
                        .map(OrderItemMapper::toDomain)
                        .toList(),
                entity.getOrderDate(),
                Order.Status.valueOf(entity.getStatus()),
                AdressMapper.toDomain(entity.getAdress()),
                new Price(entity.getPrice())
        );
    }
}