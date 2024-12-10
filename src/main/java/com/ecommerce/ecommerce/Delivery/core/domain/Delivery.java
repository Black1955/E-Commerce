package com.ecommerce.ecommerce.Delivery.core.domain;

import java.time.LocalDateTime;

public class Delivery {
    private DeliveryId id;
    private final OrderId orderId;
    private final AddressDetails deliveryDetails;
    private DeliveryStatus status;
    private final LocalDateTime deliveryDate;

    public enum DeliveryStatus {
        PENDING,
        IN_TRANSIT,
        DELIVERED,
        CANCELLED,
    }

    public Delivery(DeliveryId id, OrderId orderId, AddressDetails deliveryDetails, DeliveryStatus status, LocalDateTime deliveryDate) {
            this.deliveryDate = deliveryDate;
            this.id = id;
            this.orderId = orderId;
            this.status = status;
            this.deliveryDetails = deliveryDetails;
    }

    public static Delivery createWithoutId(OrderId orderId, AddressDetails deliveryDetails, LocalDateTime deliveryDate) {
        return new Delivery(null,orderId,deliveryDetails,DeliveryStatus.PENDING,deliveryDate);
    }

    public void setId(DeliveryId id) {
        this.id = id;
    }

    public OrderId getOrderId() {
        return orderId;
    }

    public AddressDetails getDeliveryDetails() {
        return deliveryDetails;
    }

    public DeliveryId getId() {
        return id;
    }

    public DeliveryStatus getStatus() {
        return status;
    }

    public LocalDateTime getDeliveryDate() {
        return deliveryDate;
    }
}
