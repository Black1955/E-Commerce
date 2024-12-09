package com.ecommerce.ecommerce.Payment.core.domain.Payer;

public class PaymentDetails {
    private final String cardNumber;
    private final String CVV;
    private final String expirationDate;

    public PaymentDetails(String cardNumber, String CVV, String expirationDate) {
        this.cardNumber = cardNumber;
        this.CVV = CVV;
        this.expirationDate = expirationDate;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCVV() {
        return CVV;
    }

    public String getExpirationDate() {
        return expirationDate;
    }
}
