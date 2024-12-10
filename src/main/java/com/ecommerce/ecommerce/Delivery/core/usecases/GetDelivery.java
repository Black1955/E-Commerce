package com.ecommerce.ecommerce.Delivery.core.usecases;

import com.ecommerce.ecommerce.Delivery.core.domain.Delivery;
import com.ecommerce.ecommerce.Delivery.core.domain.DeliveryId;
import com.ecommerce.ecommerce.Delivery.core.domain.OrderId;
import com.ecommerce.ecommerce.Delivery.core.domain.exceptions.DeliveryNotFoundException;
import com.ecommerce.ecommerce.Delivery.core.repositories.DeliveryRepository;

public class GetDelivery {
    private final DeliveryRepository deliveryRepository;

    public GetDelivery(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }
    Delivery getById(DeliveryId id) {
        if(id == null) throw new IllegalArgumentException("id cannot be empty");

        return this.deliveryRepository.getById(id).orElseThrow(()->new DeliveryNotFoundException(String.format("delivery with ID %s is not found", id.getValue())));
    }
    Delivery getByOrderId(OrderId id) {
        if(id == null) throw new IllegalArgumentException("id cannot be empty");

        return this.deliveryRepository.getByOrderId(id).orElseThrow(()->new DeliveryNotFoundException(String.format("delivery with ID %s is not found", id.getValue())));
    }
}
