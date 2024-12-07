package com.ecommerce.ecommerce.Order.data.JpaRepositories;

import com.ecommerce.ecommerce.Order.data.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface JpaOrderRepository extends JpaRepository<OrderEntity, String> {
    Page<OrderEntity> findByUserId(String userId, Pageable pageable);
    Page<OrderEntity> findByStatus(String status, Pageable pageable);
    Page<OrderEntity> findByStatusAndUserId(String status, Pageable pageable, String userId);
}
