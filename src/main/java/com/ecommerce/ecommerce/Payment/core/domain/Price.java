package com.ecommerce.ecommerce.Payment.core.domain;

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
}
