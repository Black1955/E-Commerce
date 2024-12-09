package com.ecommerce.ecommerce.Inventory.core.domain.events;

import com.ecommerce.ecommerce.Inventory.core.domain.OrderId;
import com.ecommerce.ecommerce.Shared.core.events.DomainEvent;

public class StockCheckedAndReserved implements DomainEvent {
    public final OrderId orderId;

    public StockCheckedAndReserved(OrderId orderId) {
        this.orderId = orderId;
    }

    public OrderId getOrderId() {
        return orderId;
    }
}
