package com.ecommerce.ecommerce.Payment.core.usecases;

import com.ecommerce.ecommerce.Payment.core.domain.Payment;
import com.ecommerce.ecommerce.Payment.core.domain.PaymentId;
import com.ecommerce.ecommerce.Payment.core.repositories.PaymentRepository;

import java.util.UUID;

public class CreatePayment {
    private final PaymentRepository paymentRepository;

    public CreatePayment(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment execute(Payment payment) {
        if(payment.getId() == null) {
            payment.setId(new PaymentId(UUID.randomUUID().toString()));
        }
        return this.paymentRepository.save(payment);
    }
}
