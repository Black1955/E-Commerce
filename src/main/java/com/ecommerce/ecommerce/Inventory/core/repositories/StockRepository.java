package com.ecommerce.ecommerce.Inventory.core.repositories;

import com.ecommerce.ecommerce.Inventory.core.domain.ProductId;
import com.ecommerce.ecommerce.Inventory.core.domain.Stock;

public interface StockRepository {
    Stock checkQuantity(ProductId id);
    Stock addItems(Stock item);
    Stock ReduceItems(Stock item);
}
