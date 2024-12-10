package com.ecommerce.ecommerce.Delivery.core.domain.exceptions;

public class DeliveryNotFoundException extends RuntimeException{
    public DeliveryNotFoundException(String message) {
        super(message);
    }
}
