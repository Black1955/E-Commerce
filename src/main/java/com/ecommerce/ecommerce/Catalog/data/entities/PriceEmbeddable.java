package com.ecommerce.ecommerce.Catalog.data.entities;

import jakarta.persistence.Embeddable;

@Embeddable
public class PriceEmbeddable {
    private float price;

    public float getPrice() {
        return price;
    }

    public void setPrice(float value) {
        this.price = value;
    }
}
