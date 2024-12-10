package com.ecommerce.ecommerce.Delivery.presenters.handlers;

import com.ecommerce.ecommerce.Delivery.core.domain.AddressDetails;
import com.ecommerce.ecommerce.Delivery.core.domain.Delivery;
import com.ecommerce.ecommerce.Delivery.core.domain.OrderId;
import com.ecommerce.ecommerce.Delivery.core.usecases.CreateDelivery;
import com.ecommerce.ecommerce.Order.core.domain.Order.events.OrderDataForDeliveryFetched;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component("OrderHandlerInDelivery")
public class OrderHandler {
    private final CreateDelivery createDelivery;

    public OrderHandler(CreateDelivery createDelivery) {
        this.createDelivery = createDelivery;
    }

    @EventListener
    public void OrderDataForDeliveryFetchedHandler(OrderDataForDeliveryFetched event) {
        AddressDetails address = new AddressDetails(event.getAdress().getCountry(),event.getAdress().getCity(),event.getAdress().getZIP(),event.getAdress().getStreet());
        Delivery delivery = Delivery.createWithoutId(new OrderId(event.getOrderId()),address,null);
        createDelivery.execute(delivery);
    }
}
