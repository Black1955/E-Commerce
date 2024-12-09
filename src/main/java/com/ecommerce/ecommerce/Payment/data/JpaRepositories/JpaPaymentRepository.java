package com.ecommerce.ecommerce.Payment.data.JpaRepositories;

import com.ecommerce.ecommerce.Payment.data.entities.PaymentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaPaymentRepository extends JpaRepository<PaymentEntity, String> {
    Page<PaymentEntity> findAllByPayer_UserId(String payer_userId, Pageable pageable);
    Optional<PaymentEntity> findByOrderId(String orderId);
}
