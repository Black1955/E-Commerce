package com.ecommerce.ecommerce.Delivery.presenters.handlers;

import com.ecommerce.ecommerce.Delivery.core.domain.events.FetchDataDelivery;
import com.ecommerce.ecommerce.Payment.core.domain.events.PaymentCreated;
import com.ecommerce.ecommerce.Shared.core.events.EventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component("PaymentHandlerInDelivery")
public class PaymentHandler {

    private final EventPublisher eventPublisher;

    public PaymentHandler(EventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @EventListener
    public void PaymentCreatedHandler(PaymentCreated event) {
        System.out.println("Event PaymentCreated is received in Delivery");
        eventPublisher.publish(new FetchDataDelivery(event.getOrderId()));
    }
}
