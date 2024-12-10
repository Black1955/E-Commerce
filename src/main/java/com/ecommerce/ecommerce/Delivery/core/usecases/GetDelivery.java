package com.ecommerce.ecommerce.Delivery.core.usecases;

import com.ecommerce.ecommerce.Delivery.core.domain.Delivery;
import com.ecommerce.ecommerce.Delivery.core.domain.DeliveryId;
import com.ecommerce.ecommerce.Delivery.core.domain.OrderId;
import com.ecommerce.ecommerce.Delivery.core.domain.exceptions.DeliveryNotFoundException;
import com.ecommerce.ecommerce.Delivery.core.repositories.DeliveryRepository;

import java.util.Optional;

public class GetDelivery {
    private final DeliveryRepository deliveryRepository;

    public GetDelivery(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }
    Delivery getById(DeliveryId id) {
        return this.deliveryRepository.getById(id).orElseThrow(()->new DeliveryNotFoundException(String.format("delivery with ID %s is not found", id.getValue())));
    }
    Delivery getByOrderId(OrderId id) {
        return this.deliveryRepository.getByOrderId(id).orElseThrow(()->new DeliveryNotFoundException(String.format("delivery with ID %s is not found", id.getValue())));
    }
}
