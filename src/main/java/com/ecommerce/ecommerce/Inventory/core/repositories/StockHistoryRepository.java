package com.ecommerce.ecommerce.Inventory.core.repositories;

import com.ecommerce.ecommerce.Inventory.core.domain.OrderId;
import com.ecommerce.ecommerce.Inventory.core.domain.StockHistory.StockHistory;
import com.ecommerce.ecommerce.Inventory.core.domain.StockHistory.StockHistoryId;
import com.ecommerce.ecommerce.Shared.Page;

import java.time.LocalDateTime;

public interface StockHistoryRepository {
    void add(StockHistory stockHistory);
    void subtract(StockHistory stockHistory);
    StockHistory getById(StockHistoryId id);
    Page<StockHistory> getAll(int size, int page);
    Page<StockHistory> getByReason(StockHistory.ReasonType reason,int size, int page);
    Page<StockHistory> getByChangeType(StockHistory.ChangeType changeType,int size, int page);
    Page<StockHistory> getByDate(LocalDateTime date,int size, int page);
    Page<StockHistory> getByOrderId(OrderId orderId,int size, int page);
}
