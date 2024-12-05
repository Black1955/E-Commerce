package com.ecommerce.ecommerce.Order.core.domain.Order;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

public class Order {
    private OrderId id;
    private UserId userId;
    private List<OrderItem> items = new ArrayList<>();
    private LocalDateTime orderDate;
    private Status status;
    private Adress adress;

    public Order(OrderId id,UserId userId, List<OrderItem> items, LocalDateTime orderDate, Status status, Adress adress) {
        this.id = id;
        this.userId = userId;
        this.items = items;
        this.orderDate = orderDate;
        this.status = status;
    }
    public static Order createWithoutId(UserId userId, List<OrderItem> items, LocalDateTime orderDate, Status status, Adress adress) {
        return new Order(null, userId, items, orderDate, status,adress);
    }
    public void setId(OrderId id) {
        if (this.id != null) {
            throw new IllegalStateException("ID is already set");
        }
        this.id = id;
    }

    public void setPending() {
        if (this.status != Status.PENDING) {
            throw new IllegalStateException("Order can only be set to PENDING once.");
        }
        this.status = Status.PENDING;
    }

    public void pay() {
        if (this.status != Status.PENDING) {
            throw new IllegalStateException("Order must be in PENDING status to be paid.");
        }
        this.status = Status.PAID;
    }

    public void cancel() {
        if (this.status == Status.COMPLETED) {
            throw new IllegalStateException("Completed orders cannot be cancelled.");
        }
        this.status = Status.CANCELLED;
    }

    public void complete() {
        if (this.status != Status.PAID) {
            throw new IllegalStateException("Order must be PAID before it can be completed.");
        }
        this.status = Status.COMPLETED;
    }

    public OrderId getId() {
        return id;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public UserId getUserId() {
        return userId;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public void setUserId(UserId userId) {
        this.userId = userId;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


    public enum Status {
        PENDING,
        PAID,
        CANCELLED,
        COMPLETED
    }
}
