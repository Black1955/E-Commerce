package com.ecommerce.ecommerce.Order.data.entities;

import jakarta.persistence.Embeddable;

@Embeddable
public class AdressEmbeddable {
    private String country;
    private String city;
    private String ZIP;
    private String street;

    protected AdressEmbeddable() {}

    public AdressEmbeddable(String country, String city, String ZIP, String street) {
        this.city = city;
        this.ZIP = ZIP;
        this.country = country;
        this.street = street;
    }

    public String getCountry() {
        return country;
    }

    public String getZIP() {
        return ZIP;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setZIP(String ZIP) {
        this.ZIP = ZIP;
    }
}
