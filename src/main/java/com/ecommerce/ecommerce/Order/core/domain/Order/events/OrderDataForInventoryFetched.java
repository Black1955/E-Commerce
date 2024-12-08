package com.ecommerce.ecommerce.Order.core.domain.Order.events;

import com.ecommerce.ecommerce.Order.core.domain.Order.OrderItem;
import com.ecommerce.ecommerce.Shared.core.events.DomainEvent;

import java.util.List;

public class OrderDataForInventoryFetched implements DomainEvent {
    public final String orderId;
    public final List<OrderItem> orderItems;
    public final float price;

    public OrderDataForInventoryFetched(String orderId,List<OrderItem> orderItems,float price) {
        this.orderId = orderId;
        this.orderItems = orderItems;
        this.price = price;
    }

    public String getOrderId() {
        return orderId;
    }

    public float getPrice() {
        return price;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }
}
