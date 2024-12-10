package com.ecommerce.ecommerce.Delivery.core.usecases;

import com.ecommerce.ecommerce.Delivery.core.domain.Delivery;
import com.ecommerce.ecommerce.Delivery.core.repositories.DeliveryRepository;

public class CreateDelivery {
    private final DeliveryRepository deliveryRepository;

    public CreateDelivery(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }
    public Delivery execute(Delivery delivery) {
        return deliveryRepository.save(delivery);
    }
}
