package com.ecommerce.ecommerce.Catalog.core.domain.product;

public class Price {
    private float value;
    public Price(float value) {
        if(value < 0) {
            throw new IllegalArgumentException("price cannot be less then 0");
        }
    }
}
