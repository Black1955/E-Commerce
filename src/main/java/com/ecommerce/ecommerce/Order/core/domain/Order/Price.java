package com.ecommerce.ecommerce.Order.core.domain.Order;

public class Price {
    private final float value;

    public Price(float value) {
        if(value < 0) {
            throw new IllegalArgumentException("price cannot be less then zero");
        }
        this.value = value;
    }

    public float getValue() {
        return value;
    }
    public Price sum(Price value) {
        return new Price(this.value + value.getValue());
    }
    public Price sub(Price value) {
        if((this.value - value.getValue() < 0)) {
            throw new IllegalArgumentException("quantity cannot be less than zero");
        }
        return new Price(this.value - value.getValue());
    }
}
