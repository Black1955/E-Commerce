package com.ecommerce.ecommerce.Order.core.domain.Order.events;

import com.ecommerce.ecommerce.Order.core.domain.Order.OrderId;
import com.ecommerce.ecommerce.Shared.core.events.DomainEvent;

public class OrderPlaced implements DomainEvent {
    public final String orderId;

    public OrderPlaced(OrderId id) {
        this.orderId = id.getValue();
    }

    public String getOrderId() {
        return orderId;
    }
}
