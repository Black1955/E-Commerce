package com.ecommerce.ecommerce.Inventory.core.domain.exceptions;

public class InsufficientStockException extends RuntimeException {
    private final int requestedQuantity;
    private final int availableQuantity;

    public InsufficientStockException(int requestedQuantity, int availableQuantity) {
        super(String.format("Insufficient stock: requested %d, but only %d available", requestedQuantity, availableQuantity));
        this.requestedQuantity = requestedQuantity;
        this.availableQuantity = availableQuantity;
    }

    public int getRequestedQuantity() {
        return requestedQuantity;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public int getShortage() {
        return requestedQuantity - availableQuantity;
    }
}
