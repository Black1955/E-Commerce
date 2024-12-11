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

    // Dependencies for publishing events, managing transactions, and handling stock-related operations
    private final EventPublisher eventPublisher;
    private final StockService stockService;
    private final TransactionManager transactionManager;

    // Constructor to inject dependencies
    public OrderHandler(EventPublisher eventPublisher, TransactionManager transactionManager, StockService stockService) {
        this.eventPublisher = eventPublisher;
        this.stockService = stockService;
        this.transactionManager = transactionManager;
    }

    /**
     * Handles the OrderPlaced event, triggered when a new order is created.
     * Publishes a FetchDataOrder event to fetch the required data for the order.
     *
     * @param event The event containing details about the placed order.
     */
    @EventListener
    @Async
    public void OrderPlacedHandler(OrderPlaced event) {
        System.out.println("Event OrderPlaced received in Inventory from Order");
        // Publish an event to fetch the order data
        eventPublisher.publish(new FetchDataOrder(event.getOrderId()));
    }

    /**
     * Handles the OrderDataForInventoryFetched event, triggered after order data has been fetched.
     * Updates the stock information based on the fetched order data and publishes a StockCheckedAndReserved event.
     *
     * @param event The event containing order data required for inventory processing.
     */
    @EventListener
    @Async
    public void OrderDataFetched(OrderDataForInventoryFetched event) {
        System.out.println("Event OrderDataForInventoryFetched received in Inventory from Order");
        // Add stock items to inventory and record the transaction history for the order
        stockService.addOrderStocksWithHistory(
                event.orderItems
                        .stream()
                        .map(orderItem ->
                                new Stock(
                                        new ProductId(orderItem.getId().getValue()), // Map product ID
                                        new Quantity(orderItem.getQuantity().getValue()) // Map product quantity
                                )
                        ).toList(),
                new OrderId(event.orderId) // Associate the order ID
        );
        // Publish an event to indicate that stock has been checked and reserved
        eventPublisher.publish(new StockCheckedAndReserved(new OrderId(event.getOrderId())));
    }
}
