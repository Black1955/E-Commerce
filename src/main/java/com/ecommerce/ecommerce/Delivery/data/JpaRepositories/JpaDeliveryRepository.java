package com.ecommerce.ecommerce.Delivery.data.JpaRepositories;

import com.ecommerce.ecommerce.Delivery.core.domain.Delivery;
import com.ecommerce.ecommerce.Delivery.core.domain.OrderId;
import com.ecommerce.ecommerce.Delivery.data.entities.DeliveryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaDeliveryRepository extends JpaRepository<DeliveryEntity,String> {
     Optional<DeliveryEntity> findByOrderId(String orderId);
}
