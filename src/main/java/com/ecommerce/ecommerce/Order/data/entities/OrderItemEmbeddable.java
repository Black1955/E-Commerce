package com.ecommerce.ecommerce.Order.data.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class OrderItemEmbeddable {

    @Column(name = "product_id", nullable = false)
    private String productId;

    private QuantityEmbeddable quantity;

    protected OrderItemEmbeddable() {}

    public OrderItemEmbeddable(String productId, QuantityEmbeddable quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }
    public QuantityEmbeddable getQuantity() {
        return quantity;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setQuantity(QuantityEmbeddable quantity) {
        this.quantity = quantity;
    }
}
