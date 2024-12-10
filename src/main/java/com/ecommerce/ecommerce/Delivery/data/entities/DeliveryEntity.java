package com.ecommerce.ecommerce.Delivery.data.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "deliveries")
public class DeliveryEntity {

    @Id
    private String id;

    @Embedded
    private AddressDetailsEmbeddable addressDetails;

    @Column(name = "order_id")
    private String orderId;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    @Column(name = "delivery_date")
    private LocalDateTime deliveryDate;


    public enum DeliveryStatus {
        PENDING,
        IN_TRANSIT,
        DELIVERED,
        CANCELLED,
    }

    public DeliveryEntity() {}

    public DeliveryEntity(String id, AddressDetailsEmbeddable addressDetails, String orderId, DeliveryStatus status, LocalDateTime deliveryDate) {
        this.addressDetails = addressDetails;
        this.deliveryDate = deliveryDate;
        this.id = id;
        this.orderId = orderId;
        this.status = status;
    }

    public DeliveryStatus getStatus() {
        return status;
    }

    public LocalDateTime getDeliveryDate() {
        return deliveryDate;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getId() {
        return id;
    }

    public AddressDetailsEmbeddable getAddressDetails() {
        return addressDetails;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setStatus(DeliveryStatus status) {
        this.status = status;
    }

    public void setAddressDetails(AddressDetailsEmbeddable addressDetails) {
        this.addressDetails = addressDetails;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setDeliveryDate(LocalDateTime deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
}
