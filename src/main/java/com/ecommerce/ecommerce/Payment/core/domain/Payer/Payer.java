package com.ecommerce.ecommerce.Payment.core.domain.Payer;

public class Payer {
    private UserId userId;
    private PaymentDetails paymentDetails;

    public Payer(UserId userId, PaymentDetails paymentDetails) {
        this.paymentDetails = paymentDetails;
        this.userId = userId;
    }

    public UserId getUserId() {
        return userId;
    }

    public PaymentDetails getPaymentDetails() {
        return paymentDetails;
    }

    public void setUserId(UserId userId) {
        this.userId = userId;
    }

    public void setPaymentDetails(PaymentDetails paymentDetails) {
        this.paymentDetails = paymentDetails;
    }
}
