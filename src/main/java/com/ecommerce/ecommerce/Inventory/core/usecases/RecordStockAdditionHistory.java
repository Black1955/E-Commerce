package com.ecommerce.ecommerce.Inventory.core.usecases;

import com.ecommerce.ecommerce.Inventory.core.domain.OrderId;
import com.ecommerce.ecommerce.Inventory.core.domain.Quantity;
import com.ecommerce.ecommerce.Inventory.core.domain.Stock;
import com.ecommerce.ecommerce.Inventory.core.domain.StockHistory.StockHistory;
import com.ecommerce.ecommerce.Inventory.core.domain.StockHistory.StockHistoryId;
import com.ecommerce.ecommerce.Inventory.core.repositories.StockHistoryRepository;

import java.util.UUID;

public class RecordStockAdditionHistory {
    private final StockHistoryRepository stockHistoryRepository;

    public RecordStockAdditionHistory(StockHistoryRepository stockHistoryRepository) {
        this.stockHistoryRepository = stockHistoryRepository;
    }

    public void execute(Stock item, OrderId orderId,StockHistory.ReasonType reason) {
        if(item == null) {
            throw new IllegalArgumentException("item cannot be null");
        }
        if(reason == null) {
            throw new IllegalArgumentException("reason cannot be null");
        }
        StockHistory stockHistory = new StockHistory(
                new StockHistoryId(UUID.randomUUID().toString()),
                item.getProductId(),
                StockHistory.ChangeType.ADD,
                new Quantity(item.getQuantity().getValue()),
                reason,
                orderId
        );
        this.stockHistoryRepository.add(stockHistory);
    }
}
