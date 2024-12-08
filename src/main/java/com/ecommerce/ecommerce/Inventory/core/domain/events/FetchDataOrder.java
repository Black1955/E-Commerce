package com.ecommerce.ecommerce.Inventory.core.domain.events;

import com.ecommerce.ecommerce.Shared.core.events.DomainEvent;

public class FetchDataOrder implements DomainEvent {
    public final String orderId;

    public FetchDataOrder(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }
}
