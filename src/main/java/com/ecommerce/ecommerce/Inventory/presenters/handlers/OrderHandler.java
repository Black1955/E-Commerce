package com.ecommerce.ecommerce.Inventory.presenters.handlers;

import com.ecommerce.ecommerce.Inventory.core.domain.OrderId;
import com.ecommerce.ecommerce.Inventory.core.domain.ProductId;
import com.ecommerce.ecommerce.Inventory.core.domain.Quantity;
import com.ecommerce.ecommerce.Inventory.core.domain.Stock;
import com.ecommerce.ecommerce.Inventory.core.domain.events.FetchDataOrder;
import com.ecommerce.ecommerce.Inventory.core.domain.events.StockCheckedAndReserved;
import com.ecommerce.ecommerce.Inventory.core.usecases.StockService;
import com.ecommerce.ecommerce.Order.core.domain.Order.events.OrderPlaced;
import com.ecommerce.ecommerce.Order.core.domain.Order.events.OrderDataForInventoryFetched;
import com.ecommerce.ecommerce.Shared.core.events.EventPublisher;
import com.ecommerce.ecommerce.Shared.core.transaction.TransactionManager;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;


@Component
public class OrderHandler {
    private final EventPublisher eventPublisher;
    private final StockService stockService;
    private final TransactionManager transactionManager;
    public OrderHandler(EventPublisher eventPublisher, TransactionManager transactionManager, StockService stockService) {
        this.eventPublisher = eventPublisher;
        this.stockService = stockService;
        this.transactionManager = transactionManager;
    }

    @EventListener
    @Async
    public void OrderPlacedHandler(OrderPlaced event) {
            System.out.println("event OrderPlaced received in Inventory from Order");
            eventPublisher.publish(new FetchDataOrder(event.getOrderId()));
    }

    @EventListener
    @Async
    public void OrderDataFetched(OrderDataForInventoryFetched event) {
        System.out.println("event OrderDataForInventoryFetched received in Inventory from Order");
            stockService.addOrderStocksWithHistory(event.orderItems.
                    stream().
                    map(orderItem ->
                            new Stock(
                                    new ProductId(orderItem.getId().getValue())
                                    ,new Quantity(orderItem.getQuantity().getValue())
                            )).toList()
                    ,new OrderId(event.orderId));
            eventPublisher.publish(new StockCheckedAndReserved(new OrderId(event.getOrderId())));
    }
}
