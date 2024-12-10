package com.ecommerce.ecommerce.Order.presenters.handlers;

import com.ecommerce.ecommerce.Delivery.core.domain.events.FetchDataDelivery;
import com.ecommerce.ecommerce.Order.core.domain.Order.Order;
import com.ecommerce.ecommerce.Order.core.domain.Order.OrderId;
import com.ecommerce.ecommerce.Order.core.domain.Order.events.OrderDataForDeliveryFetched;
import com.ecommerce.ecommerce.Order.core.usecases.FindOrderById;
import com.ecommerce.ecommerce.Shared.core.events.EventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("DeliveryHandlerInOrder")
public class DeliveryHandler {

    private final FindOrderById findOrderById;
    private final EventPublisher eventPublisher;

    public DeliveryHandler(FindOrderById findOrderById, EventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
        this.findOrderById = findOrderById;
    }

    @EventListener
    public void FetchDataDeliveryHandler(FetchDataDelivery event) {
        Optional<Order> order = findOrderById.execute(new OrderId(event.getOrderId()));
        order.ifPresent(value -> eventPublisher.publish(new OrderDataForDeliveryFetched(value.getId(), value.getAdress())));
    }
}
