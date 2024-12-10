package com.ecommerce.ecommerce.Delivery.core.domain.events;

import com.ecommerce.ecommerce.Shared.core.events.DomainEvent;

public class FetchDataDelivery implements DomainEvent {
    private final String orderId;
    public FetchDataDelivery(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }
}
