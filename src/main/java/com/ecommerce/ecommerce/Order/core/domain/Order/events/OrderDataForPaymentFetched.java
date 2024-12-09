package com.ecommerce.ecommerce.Order.core.domain.Order.events;

import com.ecommerce.ecommerce.Order.core.domain.Order.OrderId;
import com.ecommerce.ecommerce.Order.core.domain.Order.PaymentDetails;
import com.ecommerce.ecommerce.Order.core.domain.Order.Price;
import com.ecommerce.ecommerce.Order.core.domain.Order.UserId;
import com.ecommerce.ecommerce.Shared.core.events.DomainEvent;

public class OrderDataForPaymentFetched implements DomainEvent {
    private String orderId;
    private String userId;
    private String CardNumber;
    private String CVV;
    private String expirationDate;
    private float price;

    public OrderDataForPaymentFetched(OrderId orderId, UserId userId, PaymentDetails paymentDetails, Price price) {
        this.orderId = orderId.getValue();
        this.userId = userId.getValue();
        this.CVV = paymentDetails.getCVV();
        this.expirationDate = paymentDetails.getExpirationDate();
        this.CardNumber = paymentDetails.getCardNumber();
        this.price = price.getValue();
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public String getCardNumber() {
        return CardNumber;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCVV() {
        return CVV;
    }

    public String getUserId() {
        return userId;
    }

    public float getPrice() {
        return price;
    }
}
