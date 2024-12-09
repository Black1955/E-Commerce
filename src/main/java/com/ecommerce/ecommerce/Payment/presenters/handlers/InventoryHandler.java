package com.ecommerce.ecommerce.Payment.presenters.handlers;

import com.ecommerce.ecommerce.Inventory.core.domain.events.StockCheckedAndReserved;
import com.ecommerce.ecommerce.Payment.core.domain.events.FetchDataPayment;
import com.ecommerce.ecommerce.Shared.core.events.EventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component("InventoryHandlerInPayment")
public class InventoryHandler {
    private final EventPublisher eventPublisher;

    public InventoryHandler(EventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @EventListener
    @Async
    void StockCheckedAndReservedHandler(StockCheckedAndReserved event) {
        System.out.println("Event StockCheckedAndReserved received in Payment from Inventory");
        eventPublisher.publish(new FetchDataPayment(event.getOrderId().getValue()));
    }
}
