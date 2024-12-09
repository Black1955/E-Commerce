package com.ecommerce.ecommerce.Order.presenters.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.util.List;

public class OrderCreateDTO {

    @NotNull(message = "User ID cannot be null")
    private String userId;

    @NotNull(message = "Adress cannot be empty")
    private AdressDTO adress;

    @NotNull(message = "Order items cannot be null")
    private List<OrderItemDTO> orderItems;

    @Positive(message = "Price must be positive")
    private float price;

    @NotNull
    private PaymentDetailsDTO paymentDetails;

    public OrderCreateDTO(String userId, AdressDTO adress, List<OrderItemDTO> orderItems, float price, PaymentDetailsDTO paymentDetails) {
        this.userId = userId;
        this.adress = adress;
        this.orderItems = orderItems;
        this.price = price;
        this.paymentDetails = paymentDetails;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public AdressDTO getAdress() {
        return adress;
    }

    public void setAdress(AdressDTO adress) {
        this.adress = adress;
    }

    public List<OrderItemDTO> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemDTO> orderItems) {
        this.orderItems = orderItems;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public @NotNull PaymentDetailsDTO getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(@NotNull PaymentDetailsDTO paymentDetails) {
        this.paymentDetails = paymentDetails;
    }
}
