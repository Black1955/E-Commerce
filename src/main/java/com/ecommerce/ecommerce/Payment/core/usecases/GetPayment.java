package com.ecommerce.ecommerce.Payment.core.usecases;

import com.ecommerce.ecommerce.Payment.core.domain.OrderId;
import com.ecommerce.ecommerce.Payment.core.domain.Payer.UserId;
import com.ecommerce.ecommerce.Payment.core.domain.Payment;
import com.ecommerce.ecommerce.Payment.core.domain.PaymentId;
import com.ecommerce.ecommerce.Payment.core.domain.exceptions.PaymentNotFoundException;
import com.ecommerce.ecommerce.Payment.core.repositories.PaymentRepository;
import com.ecommerce.ecommerce.Shared.core.Page;

import java.util.Optional;

public class GetPayment {
    private final PaymentRepository paymentRepository;

    public GetPayment(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment GetById(PaymentId id) {
        Optional<Payment> payment = this.paymentRepository.getById(id);
        return payment.orElseThrow(() -> new PaymentNotFoundException(String.format("Payment with ID %s is not found",id.getValue())));
    }

    public Page<Payment> GetByUserId(UserId id, int page, int size) {
        return this.paymentRepository.getByUserId(id,page,size);
    }

    public Payment GetByOrderId(OrderId id) {
        Optional<Payment> payment = this.paymentRepository.getByOrderId(id);
        return payment.orElseThrow(() -> new PaymentNotFoundException(String.format("Payment with OrderID %s is not found",id.getValue())));
    }
}
