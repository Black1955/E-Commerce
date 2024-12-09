package com.ecommerce.ecommerce.Order.presenters.mappers;

import com.ecommerce.ecommerce.Order.core.domain.Order.*;
import com.ecommerce.ecommerce.Order.presenters.DTO.AdressDTO;
import com.ecommerce.ecommerce.Order.presenters.DTO.OrderCreateDTO;
import com.ecommerce.ecommerce.Order.presenters.DTO.OrderItemDTO;
import com.ecommerce.ecommerce.Shared.core.Quantity;

import java.time.LocalDateTime;

public class OrderMapper {
    public static Order toDomain(OrderCreateDTO order) {
        return Order.createWithoutId(
                new UserId(order.getUserId()),
                order.getOrderItems().stream().map(OrderMapper::toDomain).toList(),
                LocalDateTime.now(),
                OrderMapper.toDomain(order.getAdress()),
                new Price(order.getPrice())
                );
    }
    public static OrderItem toDomain(OrderItemDTO orderItem) {
        return new OrderItem(new ProductId(orderItem.getId()),new Quantity(orderItem.getQuantity()));
    }
    public static Adress toDomain(AdressDTO adress) {
        return new Adress(
                adress.getCountry(),
                adress.getCity(),
                adress.getZIP(),
                adress.getStreet()
        );
    }
}
