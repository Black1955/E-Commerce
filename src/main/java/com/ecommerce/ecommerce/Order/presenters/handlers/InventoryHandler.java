package com.ecommerce.ecommerce.Order.presenters.handlers;

import com.ecommerce.ecommerce.Inventory.core.domain.events.FetchDataOrder;
import com.ecommerce.ecommerce.Order.core.domain.Order.OrderId;
import com.ecommerce.ecommerce.Order.core.domain.Order.Order;
import com.ecommerce.ecommerce.Order.core.domain.Order.events.OrderDataForInventoryFetched;
import com.ecommerce.ecommerce.Order.core.usecases.FindOrderById;
import com.ecommerce.ecommerce.Shared.core.events.EventPublisher;
import com.ecommerce.ecommerce.Shared.core.transaction.TransactionManager;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class InventoryHandler {

    private final EventPublisher eventPublisher;
    private final FindOrderById findOrderById;
    private final TransactionManager transactionManager;
    public InventoryHandler(EventPublisher eventPublisher, FindOrderById findOrderById, TransactionManager transactionManager) {
        this.eventPublisher = eventPublisher;
        this.findOrderById = findOrderById;
        this.transactionManager = transactionManager;
    }

    @EventListener
    @Async
    public void  FetchDataOrderHandler(FetchDataOrder event) {
            System.out.println("Event FetchDataOrder is received in Order");
            Optional<Order> order = findOrderById.execute(new OrderId(event.getOrderId()));
            if(order.isPresent()) {
                eventPublisher.publish(new OrderDataForInventoryFetched(order.get().getId().getValue(),order.get().getItems(),order.get().getPrice().getValue()));
            } else {
                System.out.println(String.format("FetchDataOrderHandler: Order with ID %s not found. This should not happen.", event.getOrderId()));
                throw new IllegalStateException("Order with ID " + event.getOrderId() + " not found.");
            }
    }
}
