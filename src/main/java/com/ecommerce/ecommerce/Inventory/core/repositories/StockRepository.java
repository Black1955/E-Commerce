package com.ecommerce.ecommerce.Inventory.core.repositories;

import com.ecommerce.ecommerce.Inventory.core.domain.ProductId;
import com.ecommerce.ecommerce.Inventory.core.domain.Stock;

import java.util.Optional;

public interface StockRepository {
    Optional<Stock> checkQuantity(ProductId id);
    void SaveOrUpdateStockItem(Stock item);
    Stock ReduceItems(Stock item);
    Optional<Stock> getById(ProductId id);
}
