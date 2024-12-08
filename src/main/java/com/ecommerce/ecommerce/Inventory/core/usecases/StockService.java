package com.ecommerce.ecommerce.Inventory.core.usecases;

import com.ecommerce.ecommerce.Inventory.core.domain.OrderId;
import com.ecommerce.ecommerce.Inventory.core.domain.Quantity;
import com.ecommerce.ecommerce.Inventory.core.domain.Stock;
import com.ecommerce.ecommerce.Inventory.core.domain.StockHistory.StockHistory;
import com.ecommerce.ecommerce.Inventory.core.domain.StockHistory.StockHistoryId;
import com.ecommerce.ecommerce.Inventory.core.domain.exceptions.InsufficientStockException;
import com.ecommerce.ecommerce.Inventory.core.repositories.StockHistoryRepository;
import com.ecommerce.ecommerce.Inventory.core.repositories.StockRepository;
import com.ecommerce.ecommerce.Shared.core.transaction.TransactionManager;

import java.util.Collection;
import java.util.UUID;

public class StockService {
    private final StockRepository stockRepository;
    private final StockHistoryRepository stockHistoryRepository;
    private final TransactionManager transactionManager;
    public StockService(StockRepository stockRepository, StockHistoryRepository stockHistoryRepository, TransactionManager transactionManager) {
        this.stockHistoryRepository = stockHistoryRepository;
        this.stockRepository = stockRepository;
        this.transactionManager = transactionManager;
    }
    public void addStockWithHistory(Stock item, OrderId orderId) {
            if (!isEnough(item)) {
                throw new InsufficientStockException(
                        item.getQuantity().getValue(),
                        stockRepository.checkQuantity(item.getProductId()).map(stock1 -> stock1.getQuantity().getValue()).orElse(0)
                );
            }
            StockHistory stockHistory = new StockHistory(
                    new StockHistoryId(UUID.randomUUID().toString()),
                    item.getProductId(),
                    StockHistory.ChangeType.SUBTRACT,
                    new Quantity(item.getQuantity().getValue()),
                    StockHistory.ReasonType.ORDER_CREATED,
                    orderId
            );

            stockRepository.ReduceItems(item);
            stockHistoryRepository.add(stockHistory);
    }
    public void addOrderStocksWithHistory(Collection<Stock> items, OrderId orderId) {
         transactionManager.executeInTransaction(()->{
            for (Stock item : items) {
                addStockWithHistory(item,orderId);
            }
            return true;
        });
    }

    private boolean isEnough(Stock stock) {
        return this.stockRepository.checkQuantity(stock.getProductId()).map(stock1 -> stock1.getQuantity().getValue() > stock.getQuantity().getValue()).orElse(false);
    }
}
