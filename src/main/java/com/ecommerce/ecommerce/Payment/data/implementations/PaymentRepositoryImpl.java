package com.ecommerce.ecommerce.Payment.data.implementations;

import com.ecommerce.ecommerce.Payment.core.domain.OrderId;
import com.ecommerce.ecommerce.Payment.core.domain.Payer.UserId;
import com.ecommerce.ecommerce.Payment.core.domain.Payment;
import com.ecommerce.ecommerce.Payment.core.domain.PaymentId;
import com.ecommerce.ecommerce.Payment.core.repositories.PaymentRepository;
import com.ecommerce.ecommerce.Payment.data.JpaRepositories.JpaPaymentRepository;
import com.ecommerce.ecommerce.Payment.data.mappers.PaymentMapper;
import com.ecommerce.ecommerce.Shared.core.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public class PaymentRepositoryImpl implements PaymentRepository {

    private final JpaPaymentRepository paymentRepository;

    public PaymentRepositoryImpl(JpaPaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Payment save(Payment payment) {
        var savedPayment = paymentRepository.save(PaymentMapper.toEntity(payment));
        return PaymentMapper.toDomain(savedPayment);
    }

    @Override
    public Optional<Payment> getById(PaymentId id) {
        return paymentRepository.findById(id.getValue()).map(PaymentMapper::toDomain);
    }

    @Override
    public Page<Payment> getByUserId(UserId userId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        var payments = paymentRepository.findAllByPayer_UserId(userId.getValue(), pageable);
        return new Page<Payment>(payments.getTotalPages(),(int)payments.getTotalElements(),payments.stream().map(PaymentMapper::toDomain).toList());
    }

    @Override
    public Optional<Payment> getByOrderId(OrderId orderId) {
        return paymentRepository.findByOrderId(orderId.getValue()).map(PaymentMapper::toDomain);
    }
}
