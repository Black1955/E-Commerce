package com.ecommerce.ecommerce.Order.presenters.handlers;

import com.ecommerce.ecommerce.Order.core.domain.Order.OrderId;
import com.ecommerce.ecommerce.Order.core.domain.Order.Order;
import com.ecommerce.ecommerce.Order.core.domain.Order.events.OrderDataForPaymentFetched;
import com.ecommerce.ecommerce.Order.core.usecases.FindOrderById;
import com.ecommerce.ecommerce.Payment.core.domain.events.FetchDataPayment;
import com.ecommerce.ecommerce.Shared.core.events.EventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("PaymentHandlerInOrder")
public class PaymentHandler {

    private final EventPublisher eventPublisher;
    private final FindOrderById findOrderById;

    public PaymentHandler(EventPublisher eventPublisher, FindOrderById findOrderById) {
        this.eventPublisher = eventPublisher;
        this.findOrderById = findOrderById;
    }

    @EventListener
    @Async
    public void FetchDataPaymentHandler(FetchDataPayment event) {
        System.out.println("Event FetchDataPayment received in Order from Payment");

        Optional<Order> order = findOrderById.execute(new OrderId(event.getOrderId()));
        if(order.isPresent()) {
            var Order = order.get();
            eventPublisher.publish(new OrderDataForPaymentFetched(Order.getId(),Order.getUserId(),Order.getPaymentDetails(),Order.getPrice()));
        }
    }
}
