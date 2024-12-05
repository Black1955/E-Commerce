package com.ecommerce.ecommerce.Inventory.core.domain;

public class Stock {
    private ProductId productId;
    private Quantity quantity;

    public Stock(ProductId productId, Quantity quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public ProductId getProductId() {
        return productId;
    }

    public Quantity getQuantity() {
        return quantity;
    }
}
