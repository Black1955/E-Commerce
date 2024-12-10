package com.ecommerce.ecommerce.Order.core.domain.Order.events;

import com.ecommerce.ecommerce.Order.core.domain.Order.Adress;
import com.ecommerce.ecommerce.Order.core.domain.Order.OrderId;
import com.ecommerce.ecommerce.Shared.core.events.DomainEvent;

public class OrderDataForDeliveryFetched implements DomainEvent {
    private final String orderId;
    private final Adress adress;

    public OrderDataForDeliveryFetched(OrderId id, Adress adress) {
        this.orderId = id.getValue();
        this.adress = adress;
    }

    public String getOrderId() {
        return orderId;
    }

    public Adress getAdress() {
        return adress;
    }
}
