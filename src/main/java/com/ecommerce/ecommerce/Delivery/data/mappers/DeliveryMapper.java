package com.ecommerce.ecommerce.Delivery.data.mappers;

import com.ecommerce.ecommerce.Delivery.core.domain.AddressDetails;
import com.ecommerce.ecommerce.Delivery.core.domain.Delivery;
import com.ecommerce.ecommerce.Delivery.core.domain.DeliveryId;
import com.ecommerce.ecommerce.Delivery.core.domain.OrderId;
import com.ecommerce.ecommerce.Delivery.data.entities.AddressDetailsEmbeddable;
import com.ecommerce.ecommerce.Delivery.data.entities.DeliveryEntity;

public class DeliveryMapper {
    public static Delivery toDomain(DeliveryEntity entity) {
        AddressDetails addressDetails = new AddressDetails(
                entity.getAddressDetails().getCountry(),
                entity.getAddressDetails().getCity(),
                entity.getAddressDetails().getZIP(),
                entity.getAddressDetails().getStreet()
        );

        return new Delivery(
                new DeliveryId(entity.getId()),
                new OrderId(entity.getOrderId()),
                addressDetails,
                Delivery.DeliveryStatus.valueOf(entity.getStatus().name()),
                entity.getDeliveryDate()
        );
    }

    public static DeliveryEntity toEntity(Delivery delivery) {
        AddressDetailsEmbeddable addressDetailsEmbeddable = new AddressDetailsEmbeddable(
                delivery.getDeliveryDetails().getCountry(),
                delivery.getDeliveryDetails().getCity(),
                delivery.getDeliveryDetails().getZIP(),
                delivery.getDeliveryDetails().getStreet()
        );

        return new DeliveryEntity(
                delivery.getId() != null ? delivery.getId().getValue() : null,
                addressDetailsEmbeddable,
                delivery.getOrderId().getValue(),
                DeliveryEntity.DeliveryStatus.valueOf(delivery.getStatus().name()),
                delivery.getDeliveryDate()
        );
    }

}
