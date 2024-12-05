package com.ecommerce.ecommerce.Inventory.core.domain;

public class Quantity {
    private final int value;

    public Quantity(int value) {
        if(value < 0) {
            throw new IllegalArgumentException("quantity cannot me less then zero");
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Quantity add(Quantity value) {
        if (value == null) {
            throw new IllegalArgumentException("Quantity to add cannot be null");
        }
        return new Quantity(this.value + value.getValue());
    }
    public Quantity sub(Quantity value) {
        if (value == null) {
            throw new IllegalArgumentException("Quantity to add cannot be null");
        }
        if (this.value < value.getValue()) {
            throw new IllegalArgumentException("Resulting quantity cannot be less than zero");
        }
        return new Quantity(this.value - value.getValue());
    }
}
