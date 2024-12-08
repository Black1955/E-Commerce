package com.ecommerce.ecommerce.Inventory.core.domain.exceptions;

public class StockNotFoundException extends RuntimeException {
    public StockNotFoundException(String message) {
        super(message);
    }
}
