package com.ecommerce.ecommerce.Order.core.domain.Order;

public class PaymentDetails {
    private final String CardNumber;
    private final String CVV;
    private final String expirationDate;

    public PaymentDetails(String CardNumber,String CVV,String expirationDate) {
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
