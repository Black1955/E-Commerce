package com.ecommerce.ecommerce.Payment.data.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "payments")
public class PaymentEntity {

    @Id
    private String id;

    private float price;

    @Embedded
    private PayerEmbeddable payer;

    @Column(name = "order_id", nullable = false)
    private String orderId;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private PaymentStatus status;

    public enum PaymentStatus {
        PENDING,
        COMPLETED,
        CANCELED,
        REFUNDED
    }
    public PaymentEntity() {}
    public PaymentEntity(String id, float price, PayerEmbeddable payer, String orderId, LocalDateTime createdAt, PaymentStatus status) {
        this.id = id;
        this.createdAt = createdAt;
        this.price = price;
        this.payer = payer;
        this.orderId = orderId;
        this.status = status;
    }
    public String getOrderId() {
        return orderId;
    }

    public float getPrice() {
        return price;
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public PayerEmbeddable getPayer() {
        return payer;
    }

    public PaymentStatus getStatus() {
        return status;
    }
}