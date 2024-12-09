package com.ecommerce.ecommerce.Payment.core.usecases;

import com.ecommerce.ecommerce.Payment.core.domain.Payment;
import com.ecommerce.ecommerce.Payment.core.repositories.PaymentRepository;

public class UpdatePayment {
    private final PaymentRepository paymentRepository;

   public UpdatePayment(PaymentRepository paymentRepository) {
       this.paymentRepository = paymentRepository;
   }

   public Payment execute(Payment payment) {
       return this.paymentRepository.save(payment);
   }
}
