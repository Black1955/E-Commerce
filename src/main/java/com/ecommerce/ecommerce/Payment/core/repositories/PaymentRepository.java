package com.ecommerce.ecommerce.Payment.core.repositories;

import com.ecommerce.ecommerce.Payment.core.domain.*;
import com.ecommerce.ecommerce.Payment.core.domain.Payer.UserId;
import com.ecommerce.ecommerce.Shared.core.Page;

import java.util.List;
import java.util.Optional;

public interface PaymentRepository {
    Payment save(Payment payment);

    Optional<Payment> getById(PaymentId id);

    Page<Payment> getByUserId(UserId userId, int page, int size);

    Optional<Payment> getByOrderId(OrderId orderId);
}
