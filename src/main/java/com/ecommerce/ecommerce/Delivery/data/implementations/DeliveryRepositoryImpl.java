package com.ecommerce.ecommerce.Delivery.data.implementations;

import com.ecommerce.ecommerce.Delivery.core.domain.Delivery;
import com.ecommerce.ecommerce.Delivery.core.domain.DeliveryId;
import com.ecommerce.ecommerce.Delivery.core.domain.OrderId;
import com.ecommerce.ecommerce.Delivery.core.repositories.DeliveryRepository;
import com.ecommerce.ecommerce.Delivery.data.JpaRepositories.JpaDeliveryRepository;
import com.ecommerce.ecommerce.Delivery.data.mappers.DeliveryMapper;

import java.util.Optional;

public class DeliveryRepositoryImpl implements DeliveryRepository {

    private final JpaDeliveryRepository deliveryRepository;

    public DeliveryRepositoryImpl(JpaDeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    @Override
    public Delivery save(Delivery delivery) {
        var savedDelivery = deliveryRepository.save(DeliveryMapper.toEntity(delivery));
        return DeliveryMapper.toDomain(savedDelivery);
    }

    @Override
    public Optional<Delivery> getById(DeliveryId id) {
        return deliveryRepository.findById(id.getValue()).map(DeliveryMapper::toDomain);
    }

    @Override
    public Optional<Delivery> getByOrderId(OrderId id) {
        return deliveryRepository.findByOrderId(id.getValue()).map(DeliveryMapper::toDomain);
    }
}
