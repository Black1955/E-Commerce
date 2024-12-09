package com.ecommerce.ecommerce.Payment.core.domain.events;

import com.ecommerce.ecommerce.Shared.core.events.DomainEvent;

public class PaymentCreated implements DomainEvent {
    private final String orderId;
    private final String paymentId;

    public PaymentCreated(String orderId, String paymentId) {
        this.orderId = orderId;
        this.paymentId = paymentId;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getPaymentId() {
        return paymentId;
    }
}
