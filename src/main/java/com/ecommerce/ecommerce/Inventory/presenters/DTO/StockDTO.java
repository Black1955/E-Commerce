package com.ecommerce.ecommerce.Inventory.presenters.DTO;

public class StockDTO {
    private String productId;
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
