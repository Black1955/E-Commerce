package com.ecommerce.ecommerce.Inventory.core.usecases;

import com.ecommerce.ecommerce.Inventory.core.domain.ProductId;
import com.ecommerce.ecommerce.Inventory.core.domain.Stock;
import com.ecommerce.ecommerce.Inventory.core.repositories.StockRepository;

public class IsInStock {
    private final StockRepository stockRepository;

    public IsInStock(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }
    Stock execute(ProductId id) {
        if(id == null) {
            throw new IllegalArgumentException("id cannot be empty");
        }
        return this.stockRepository.checkQuantity(id);
    }
}
