package com.ecommerce.ecommerce.Payment.core.domain.events;

import com.ecommerce.ecommerce.Shared.core.events.DomainEvent;

public class FetchDataPayment implements DomainEvent {
    public final String orderId;

    public FetchDataPayment(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }
}
