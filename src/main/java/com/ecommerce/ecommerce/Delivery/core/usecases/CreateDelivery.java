package com.ecommerce.ecommerce.Delivery.core.usecases;

import com.ecommerce.ecommerce.Delivery.core.domain.Delivery;
import com.ecommerce.ecommerce.Delivery.core.domain.DeliveryId;
import com.ecommerce.ecommerce.Delivery.core.repositories.DeliveryRepository;

import java.util.UUID;

public class CreateDelivery {
    private final DeliveryRepository deliveryRepository;

    public CreateDelivery(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }
    public Delivery execute(Delivery delivery) {
        if(delivery.getId() == null) {
            delivery.setId(new DeliveryId(UUID.randomUUID().toString()));
        }
        return deliveryRepository.save(delivery);
    }
}
