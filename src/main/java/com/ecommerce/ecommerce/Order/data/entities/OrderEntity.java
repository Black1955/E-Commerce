package com.ecommerce.ecommerce.Order.data.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    private String id;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "order_date", nullable = false)
    private LocalDateTime orderDate;

    @Column(nullable = false)
    private String status;

    @Embedded
    private AdressEmbeddable adress;

    private float price;

    @ElementCollection
    @CollectionTable(name = "order_items", joinColumns = @JoinColumn(name = "order_id"))
    private List<OrderItemEmbeddable> orderItems = new ArrayList<>();

    public OrderEntity() {}

    public OrderEntity(String id, String userId, LocalDateTime orderDate, String status, AdressEmbeddable adress, List<OrderItemEmbeddable> orderItems, float price) {
        this.id = id;
        this.userId = userId;
        this.orderDate = orderDate;
        this.orderItems = orderItems;
        this.adress = adress;
        this.status = status;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public List<OrderItemEmbeddable> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemEmbeddable> orderItems) {
        this.orderItems = orderItems;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public String getStatus() {
        return status;
    }

    public AdressEmbeddable getAdress() {
        return adress;
    }

    public String getUserId() {
        return userId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setAdress(AdressEmbeddable adress) {
        this.adress = adress;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
