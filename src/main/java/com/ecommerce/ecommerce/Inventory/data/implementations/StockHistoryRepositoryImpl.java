package com.ecommerce.ecommerce.Inventory.data.implementations;

import com.ecommerce.ecommerce.Inventory.core.domain.OrderId;
import com.ecommerce.ecommerce.Inventory.core.domain.StockHistory.StockHistory;
import com.ecommerce.ecommerce.Inventory.core.domain.StockHistory.StockHistoryId;
import com.ecommerce.ecommerce.Inventory.core.repositories.StockHistoryRepository;
import com.ecommerce.ecommerce.Inventory.data.JpaRepositories.JpaStockHistoryRepository;
import com.ecommerce.ecommerce.Inventory.data.mappers.StockHistoryMapper;
import com.ecommerce.ecommerce.Shared.core.Page;

import java.time.LocalDateTime;

public class StockHistoryRepositoryImpl implements StockHistoryRepository {
    private final JpaStockHistoryRepository stockHistoryRepository;

    public StockHistoryRepositoryImpl(JpaStockHistoryRepository stockHistoryRepository) {
        this.stockHistoryRepository = stockHistoryRepository;
    }

    @Override
    public void add(StockHistory stockHistory) {
        stockHistoryRepository.save(StockHistoryMapper.toEntity(stockHistory));
    }

    @Override
    public void delete(OrderId orderId) {
        stockHistoryRepository.deleteAllByOrderId(orderId.getValue());
    }

    @Override
    public StockHistory getById(StockHistoryId id) {
        return null;
    }

    @Override
    public Page<StockHistory> getAll(int size, int page) {
        return null;
    }

    @Override
    public Page<StockHistory> getByReason(StockHistory.ReasonType reason, int size, int page) {
        return null;
    }

    @Override
    public Page<StockHistory> getByChangeType(StockHistory.ChangeType changeType, int size, int page) {
        return null;
    }

    @Override
    public Page<StockHistory> getByDate(LocalDateTime date, int size, int page) {
        return null;
    }

    @Override
    public Page<StockHistory> getByOrderId(OrderId orderId, int size, int page) {
        return null;
    }
}
