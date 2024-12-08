package com.ecommerce.ecommerce.Order.presenters.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class OrderItemDTO {

    @NotNull(message = "id cannot be empty")
    private String id;

    @Positive
    @NotNull(message = "quantity cannot be empty")
    @Size(min = 1)
    private int quantity;

    public OrderItemDTO(String id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setId(String id) {
        this.id = id;
    }

}
