package com.ecommerce.ecommerce.Payment.core.domain;

import com.ecommerce.ecommerce.Payment.core.domain.Payer.Payer;

import java.time.LocalDateTime;

public class Payment {
    private PaymentId id;
    private Price price;
    private Payer payer;
    private OrderId orderId;
    private LocalDateTime createdAt;
    private PaymentStatus status;


    public enum PaymentStatus {
        PENDING,
        COMPLETED,
        CANCELED,
        REFUNDED
    }

    public Payment(PaymentId id, Price price, Payer payer, OrderId orderId, LocalDateTime createdAt, PaymentStatus status) {
        this.id = id;
        this.createdAt = createdAt;
        this.price = price;
        this.payer = payer;
        this.orderId = orderId;
        this.status = status;
    }
    public static Payment createWithoutId(Price price, Payer payer, OrderId orderId) {
        return new Payment(null, price, payer, orderId, LocalDateTime.now(),PaymentStatus.PENDING);
    }

    public PaymentId getId() {
        return id;
    }

    public Price getPrice() {
        return price;
    }

    public Payer getPayer() {
        return payer;
    }

    public OrderId getOrderId() {
        return orderId;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setId(PaymentId id) {
        this.id = id;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }
}
