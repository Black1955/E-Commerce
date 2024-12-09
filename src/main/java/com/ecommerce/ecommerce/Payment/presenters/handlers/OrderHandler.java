package com.ecommerce.ecommerce.Payment.presenters.handlers;

import com.ecommerce.ecommerce.Order.core.domain.Order.events.OrderDataForPaymentFetched;
import com.ecommerce.ecommerce.Payment.core.domain.OrderId;
import com.ecommerce.ecommerce.Payment.core.domain.Payer.Payer;
import com.ecommerce.ecommerce.Payment.core.domain.Payer.PaymentDetails;
import com.ecommerce.ecommerce.Payment.core.domain.Payer.UserId;
import com.ecommerce.ecommerce.Payment.core.domain.Payment;
import com.ecommerce.ecommerce.Payment.core.domain.Price;
import com.ecommerce.ecommerce.Payment.core.domain.events.PaymentCreated;
import com.ecommerce.ecommerce.Payment.core.usecases.CreatePayment;
import com.ecommerce.ecommerce.Shared.core.events.EventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component("OrderHandlerInPayment")
public class OrderHandler {

    private final CreatePayment createPayment;
    private final EventPublisher eventPublisher;
    public OrderHandler(CreatePayment createPayment, EventPublisher eventPublisher) {
        this.createPayment = createPayment;
        this.eventPublisher = eventPublisher;
    }

    @EventListener
    @Async
    public void OrderDataForPaymentFetchedHandler(OrderDataForPaymentFetched event) {
        System.out.println("Event OrderDataForPaymentFetched received in Payment from Order");
        Payer payer = new Payer(new UserId(event.getUserId()),new PaymentDetails(event.getCardNumber(),event.getCVV(),event.getExpirationDate()));
        Payment payment = Payment.createWithoutId(new Price(event.getPrice()), payer, new OrderId(event.getOrderId()));
        var savedPayment = createPayment.execute(payment);
        eventPublisher.publish(new PaymentCreated(savedPayment.getOrderId().getValue(),savedPayment.getId().getValue()));
    }
}
