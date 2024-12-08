package com.ecommerce.ecommerce.Inventory.data.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "stock_history")
public class StockHistoryEntity {

    @Id
    private String id;

    @Column(name = "product_id", nullable = false)
    private String productId;

    @Column(name = "order_id")
    private String orderId;

    @Enumerated(EnumType.STRING)
    @Column(name = "change_type", nullable = false)
    private ChangeType changeType;

    @Column(name = "change_amount", nullable = false)
    private int changeAmount;

    @Enumerated(EnumType.STRING)
    @Column(name = "reason", nullable = false)
    private ReasonType reason;

    @Column(name = "timestamp", nullable = false)
    private LocalDateTime timestamp;

    public StockHistoryEntity() {}

    public StockHistoryEntity(String id, String productId, String orderId, ChangeType changeType, int changeAmount, ReasonType reason, LocalDateTime timestamp) {
        this.id = id;
        this.productId = productId;
        this.orderId = orderId;
        this.changeType = changeType;
        this.changeAmount = changeAmount;
        this.reason = reason;
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public ChangeType getChangeType() {
        return changeType;
    }

    public void setChangeType(ChangeType changeType) {
        this.changeType = changeType;
    }

    public int getChangeAmount() {
        return changeAmount;
    }

    public void setChangeAmount(int changeAmount) {
        this.changeAmount = changeAmount;
    }

    public ReasonType getReason() {
        return reason;
    }

    public void setReason(ReasonType reason) {
        this.reason = reason;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public enum ChangeType {
        ADD,
        SUBTRACT
    }

    public enum ReasonType {
        ORDER_CREATED,
        ORDER_CANCELLED,
        RESTOCK,
        RETURN
    }
}
