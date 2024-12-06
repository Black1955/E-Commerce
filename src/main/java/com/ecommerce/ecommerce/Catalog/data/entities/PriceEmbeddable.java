package com.ecommerce.ecommerce.Catalog.data.entities;

import jakarta.persistence.Embeddable;

@Embeddable
public class PriceEmbeddable {
    private float value;

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}
