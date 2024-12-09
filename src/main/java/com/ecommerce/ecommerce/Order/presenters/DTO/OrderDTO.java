package com.ecommerce.ecommerce.Order.presenters.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class OrderDTO {

    @NotNull(message = "ID cannot be null")
    private String id;

    @NotNull(message = "User ID cannot be null")
    private String userId;

    @NotNull(message = "adress cannot be empty")
    private AdressDTO adress;

    @NotNull(message = "Order items cannot be null")
    private List<OrderItemDTO> orderItems;

    @Positive(message = "Price must be positive")
    private float price;

    @NotNull(message = "Status cannot be null")
    @Size(min = 1, max = 20, message = "Status length must be between 1 and 20 characters")
    private String status;

    @NotNull(message = "Creation date cannot be null")
    private LocalDateTime createdAt;

    @NotNull
    private PaymentDetailsDTO paymentDetails;

    public OrderDTO(String id, String userId, AdressDTO adress, List<OrderItemDTO> orderItems, float price, String status, LocalDateTime createdAt, PaymentDetailsDTO paymentDetails) {
        this.id = id;
        this.userId = userId;
        this.adress = adress;
        this.orderItems = orderItems;
        this.price = price;
        this.status = status;
        this.createdAt = createdAt;
        this.paymentDetails = paymentDetails;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = LocalDateTime.parse(createdAt, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
    }

    public @NotNull PaymentDetailsDTO getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(@NotNull PaymentDetailsDTO paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public void setCreatedAt(@NotNull(message = "Creation date cannot be null") LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}