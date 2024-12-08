package com.ecommerce.ecommerce.Inventory.data.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "stocks")
public class StockEntity {

    @Id
    @Column(name = "product_id")
    private String productId;

    private int quantity;

    public StockEntity() {}

    public StockEntity(String productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getProductId() {
        return productId;
    }
}
