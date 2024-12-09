package com.ecommerce.ecommerce.Order.data.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class PaymentDetailsEmbeddable {
    @Column(name = "card_number")
    private String CardNumber;
    private String CVV;
    @Column(name = "expiration_date")
    private String expirationDate;

    public PaymentDetailsEmbeddable() {}

    public PaymentDetailsEmbeddable(String CardNumber, String CVV, String expirationDate) {
        this.CardNumber = CardNumber;
        this.CVV = CVV;
        this.expirationDate = expirationDate;
    }

    public String getCardNumber() {
        return CardNumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public String getCVV() {
        return CVV;
    }
}
