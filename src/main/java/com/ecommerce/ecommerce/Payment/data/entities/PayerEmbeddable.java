package com.ecommerce.ecommerce.Payment.data.entities;

import com.ecommerce.ecommerce.Payment.core.domain.Payer.PaymentDetails;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Column;

@Embeddable
public class PayerEmbeddable {
    @Column(name = "user_id", nullable = false)
    private String userId;

    @Embedded
    private PaymentDetailsEmbeddable paymentDetails;

    public PayerEmbeddable() {}

    public PayerEmbeddable(String userId, PaymentDetailsEmbeddable paymentDetails) {
        this.userId = userId;
        this.paymentDetails = paymentDetails;
    }

    public PaymentDetailsEmbeddable getPaymentDetails() {
        return paymentDetails;
    }

    public String getUserId() {
        return userId;
    }

    public void setPaymentDetails(PaymentDetailsEmbeddable paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
