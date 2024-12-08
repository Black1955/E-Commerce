package com.ecommerce.ecommerce.Order.data.entities;

import jakarta.persistence.Embeddable;

@Embeddable
public class QuantityEmbeddable {
    private int quantity;

    public QuantityEmbeddable() {}

    public QuantityEmbeddable(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }
}
