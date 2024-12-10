package com.ecommerce.ecommerce.Delivery.core.domain;

public class AddressDetails {
    private String country;
    private String city;
    private String ZIP;
    private String street;

    public AddressDetails(String country, String city, String ZIP, String street) {
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
}
