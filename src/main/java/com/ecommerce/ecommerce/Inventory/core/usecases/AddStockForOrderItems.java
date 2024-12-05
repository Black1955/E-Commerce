package com.ecommerce.ecommerce.Inventory.core.usecases;

import com.ecommerce.ecommerce.Inventory.core.domain.OrderId;
import com.ecommerce.ecommerce.Inventory.core.domain.Quantity;
import com.ecommerce.ecommerce.Inventory.core.domain.Stock;
import com.ecommerce.ecommerce.Inventory.core.domain.StockHistory.StockHistory;
import com.ecommerce.ecommerce.Inventory.core.domain.StockHistory.StockHistoryId;
import com.ecommerce.ecommerce.Inventory.core.domain.exceptions.InsufficientStockException;
import com.ecommerce.ecommerce.Inventory.core.repositories.StockHistoryRepository;
import com.ecommerce.ecommerce.Inventory.core.repositories.StockRepository;

import java.util.Collection;
import java.util.UUID;

public class AddStockForOrderItems {
    private final StockRepository stockRepository;
    private final StockHistoryRepository stockHistoryRepository;
    public AddStockForOrderItems(StockRepository stockRepository, StockHistoryRepository stockHistoryRepository) {
        this.stockRepository = stockRepository;
        this.stockHistoryRepository = stockHistoryRepository;
    }

    public void execute(Collection<Stock> items, OrderId orderId) {
        for (Stock item : items) {
            if (this.stockRepository.checkQuantity(item.getProductId()).getQuantity().getValue() < item.getQuantity().getValue()) {
                throw new InsufficientStockException(
                        item.getQuantity().getValue(),
                        stockRepository.checkQuantity(item.getProductId()).getQuantity().getValue()
                );
            }
            StockHistory stockHistory = new StockHistory(
                    new StockHistoryId(UUID.randomUUID().toString()),
                    item.getProductId(),
                    StockHistory.ChangeType.ADD,
                    new Quantity(item.getQuantity().getValue()),
                    StockHistory.ReasonType.ORDER_CREATED,orderId
            );

            stockHistoryRepository.add(stockHistory);
            stockRepository.addItems(item);
        }
    }
}

