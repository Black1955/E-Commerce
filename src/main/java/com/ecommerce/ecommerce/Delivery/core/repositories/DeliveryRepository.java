package com.ecommerce.ecommerce.Delivery.core.repositories;

import com.ecommerce.ecommerce.Delivery.core.domain.Delivery;
import com.ecommerce.ecommerce.Delivery.core.domain.DeliveryId;
import com.ecommerce.ecommerce.Delivery.core.domain.OrderId;

import java.util.Optional;

public interface DeliveryRepository {
    Delivery save(Delivery delivery);
    Optional<Delivery> getById(DeliveryId id);
    Optional<Delivery> getByOrderId(OrderId id);
}
