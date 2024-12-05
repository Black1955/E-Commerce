package com.ecommerce.ecommerce.Order.core.domain.Order;

public class OrderItem {
    private ProductId id;
    private int quantity;

    public OrderItem(ProductId id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public ProductId getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }
}
