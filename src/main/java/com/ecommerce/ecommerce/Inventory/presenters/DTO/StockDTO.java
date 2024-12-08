package com.ecommerce.ecommerce.Inventory.presenters.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class StockDTO {
    @NotBlank
    private String productId;

    @NotBlank
    @Positive
    @Size(min = 1)
    private int quantity;

    public StockDTO(String productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
