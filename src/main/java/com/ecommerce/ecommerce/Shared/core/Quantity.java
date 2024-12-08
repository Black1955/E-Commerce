package com.ecommerce.ecommerce.Shared.domain;

public class Quantity {
    private final int value;

    public Quantity(int value) {
        if(value < 0) {
            throw new IllegalArgumentException("quantity cannot be less than zero");
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    public Quantity add(Quantity sum) {
        return new Quantity(this.value + sum.getValue());
    }
    public Quantity sub(Quantity sub) {
        if((this.value - sub.getValue()) < 0) {
            throw new IllegalArgumentException("quantity cannot be less than zero");
        }
        return new Quantity(this.value - sub.getValue());
    }
}
