package com.ecommerce.ecommerce.Order.presenters.DTO;

import jakarta.validation.constraints.NotNull;

public class AdressDTO {
    @NotNull(message = "country cannot be empty")
    private String country;
    @NotNull(message = "city cannot be empty")
    private String city;
    @NotNull(message = "ZIP cannot be empty")
    private String ZIP;
    @NotNull(message = "street cannot be empty")
    private String street;

    public AdressDTO(String country, String city, String ZIP, String street) {
        this.city = city;
        this.country = country;
        this.street = street;
        this.ZIP = ZIP;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getStreet() {
        return street;
    }

    public String getZIP() {
        return ZIP;
    }

    public void setZIP(String ZIP) {
        this.ZIP = ZIP;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
