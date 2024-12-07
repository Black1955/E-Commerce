package com.ecommerce.ecommerce.Order.core.domain.Order;

import com.ecommerce.ecommerce.Shared.Quantity;

public class OrderItem {
    private ProductId id;
    private Quantity quantity;

    public OrderItem(ProductId id, Quantity quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public ProductId getId() {
        return id;
    }

    public Quantity getQuantity() {
        return quantity;
    }
}
